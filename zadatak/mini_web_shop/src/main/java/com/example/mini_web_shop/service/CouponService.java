package com.example.mini_web_shop.service;

import com.example.mini_web_shop.model.Coupon;

import java.util.List;

public interface CouponService {

    List<Coupon> getCouponByCode(String code);
}
