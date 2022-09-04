package com.cause.request.repeat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author causeThenEffect
 */
@Service
@Slf4j
public class OrderService {

    /**
     * 记录已经下单的用户
     */
    private volatile Map<Long, Boolean> createdOrderMap = new ConcurrentHashMap<>();

    /**
     * 总的下单数量
     */
    private volatile int saleCount = 0;

    public String createOrder(Long userId) {
        try {
            Boolean flag = createdOrderMap.getOrDefault(userId, false);
            if (!flag) {
                Thread.sleep(2000);
                createdOrderMap.put(userId, true);
                saleCount++;
            }
            return "订单创建成功，总的卖出" + saleCount + "件";
        } catch (Exception e) {
            log.error("createOrder: {}", e.getMessage(), e);
        }
        return "创建订单失败，总的卖出" + saleCount + "件";
    }

}
