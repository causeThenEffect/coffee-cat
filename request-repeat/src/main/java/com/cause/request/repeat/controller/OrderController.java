package com.cause.request.repeat.controller;

import com.cause.request.repeat.annotation.RequestRepeatIntercept;
import com.cause.request.repeat.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author causeThenEffect
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping(value = "/create")
    @RequestRepeatIntercept(value = "/order/create")
    public String createOrder(@RequestParam Long userId ) {
        return orderService.createOrder(userId);
    }

}
