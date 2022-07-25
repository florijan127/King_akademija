package com.example.mini_web_shop.controller;

import com.example.mini_web_shop.model.Coupon;
import com.example.mini_web_shop.model.Order;
import com.example.mini_web_shop.service.CouponService;
import com.example.mini_web_shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    ResponseEntity<String> getCouponByCode(@RequestBody Order order) {
        orderService.save(order);
        return ResponseEntity.ok().body("Ok");
    }
}