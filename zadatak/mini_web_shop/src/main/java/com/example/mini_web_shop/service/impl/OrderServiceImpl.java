package com.example.mini_web_shop.service.impl;

import com.example.mini_web_shop.model.Order;
import com.example.mini_web_shop.repository.OrderRepository;
import com.example.mini_web_shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;



    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

}
