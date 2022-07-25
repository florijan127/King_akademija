package com.example.mini_web_shop.repository;

import com.example.mini_web_shop.model.Coupon;

import java.util.List;

public interface CouponCustomRepository {
    List<Coupon> getCouponByCode(String code);
}
