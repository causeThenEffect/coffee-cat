package com.cause.request.repeat.aspect;

import com.cause.request.repeat.annotation.RequestRepeatIntercept;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author causeThenEffect
 */
@Aspect
@Component
@Slf4j
public class RequestRepeatAspect {

    @Resource
    RedissonClient redissonClient;

    /**
     * 锁超时时间太大：没有影响，不管最终执行结果如何都会释放锁，除非锁释放失败
     * 锁超时时间小于执行时间：执行没有结束，其他请求获取到了锁，这种场景就算是锁失效了
     * 锁超时时间必须大于执行时间
     *
     * @param joinPoint
     * @param requestRepeatIntercept
     * @return
     * @throws Throwable
     */
    @Around("@annotation(requestRepeatIntercept)")
    public Object intercept(ProceedingJoinPoint joinPoint, RequestRepeatIntercept requestRepeatIntercept) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String api = requestRepeatIntercept.value();
        String userId = args[0].toString();
        String lockKey = api + ":" + userId;
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(50, TimeUnit.SECONDS);
        log.info("lock key:{}", lockKey);
        Object object;
        try {
            object = joinPoint.proceed();
        } finally {
            if (lock.isLocked()) {
                try {
                    lock.unlock();
                } catch (Exception e) {
                    log.error("unlock error:{}", e.getMessage(), e);
                }
            }
        }
        log.info("result:{}", object.toString());
        return object;
    }

}
