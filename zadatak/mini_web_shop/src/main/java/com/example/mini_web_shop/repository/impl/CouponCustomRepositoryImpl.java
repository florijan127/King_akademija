package com.example.mini_web_shop.repository.impl;

import com.example.mini_web_shop.model.Coupon;
import com.example.mini_web_shop.repository.CouponCustomRepository;
import com.example.mini_web_shop.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class CouponCustomRepositoryImpl implements CouponCustomRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Coupon> getCouponByCode(String code) {
        return entityManager.createQuery("select c from Coupon c where c.code = :code", Coupon.class)
                .setParameter("code", code)
                .getResultList();
    }
}
