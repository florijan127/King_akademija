package com.example.mini_web_shop.controller;

import com.example.mini_web_shop.model.Coupon;
import com.example.mini_web_shop.model.Item;
import com.example.mini_web_shop.service.CouponService;
import com.example.mini_web_shop.service.impl.CouponServiceImpl;
import com.example.mini_web_shop.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/coupons")
public class CouponsController {

    @Autowired
    private CouponService couponService;

    @PutMapping
    ResponseEntity<List<Coupon>> getCouponByCode(@RequestBody String code) {
        return ResponseEntity.ok().body(couponService.getCouponByCode(code));
    }
}