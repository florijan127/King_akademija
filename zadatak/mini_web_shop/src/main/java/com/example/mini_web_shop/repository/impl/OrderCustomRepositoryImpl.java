package com.example.mini_web_shop.repository.impl;

import com.example.mini_web_shop.model.Order;
import com.example.mini_web_shop.repository.OrderCustomRepository;
import com.example.mini_web_shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class OrderCustomRepositoryImpl implements OrderCustomRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public void addOrder(Order order) {


    }
}
