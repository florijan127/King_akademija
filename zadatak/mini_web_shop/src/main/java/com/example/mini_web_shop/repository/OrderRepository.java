package com.example.mini_web_shop.repository;

import com.example.mini_web_shop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> /*, OrderCustomRepository*/{
}
