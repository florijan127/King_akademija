package com.example.mini_web_shop.repository;

import com.example.mini_web_shop.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>, ItemCustomRepository {
}
