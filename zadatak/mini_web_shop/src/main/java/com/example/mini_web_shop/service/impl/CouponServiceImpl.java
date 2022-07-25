package com.example.mini_web_shop.service.impl;

import com.example.mini_web_shop.model.Coupon;
import com.example.mini_web_shop.repository.CouponRepository;
import com.example.mini_web_shop.repository.impl.CouponCustomRepositoryImpl;
import com.example.mini_web_shop.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;


    @Override
    public List<Coupon> getCouponByCode(String code) {
        return couponRepository.getCouponByCode(code);
    }
}
