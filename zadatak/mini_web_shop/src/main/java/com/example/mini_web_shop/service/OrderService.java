package com.example.mini_web_shop.service;

import com.example.mini_web_shop.model.Order;
import com.example.mini_web_shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface OrderService {

    void save(Order order);
}
