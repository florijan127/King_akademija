package com.example.mini_web_shop.repository;

import com.example.mini_web_shop.dto.ItemDto;
import com.example.mini_web_shop.model.Item;

import java.util.List;

public interface ItemCustomRepository {

    List<Item> filter(String prodName, String brandName, Double maxPrice);
}
