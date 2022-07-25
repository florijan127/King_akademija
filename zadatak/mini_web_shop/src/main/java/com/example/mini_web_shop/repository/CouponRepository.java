package com.example.mini_web_shop.repository;

import com.example.mini_web_shop.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer>, CouponCustomRepository {

    
}
