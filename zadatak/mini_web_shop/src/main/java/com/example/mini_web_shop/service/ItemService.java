package com.example.mini_web_shop.service;

import com.example.mini_web_shop.dto.ItemDto;
import com.example.mini_web_shop.form.Filter;
import com.example.mini_web_shop.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();


    List<Item> filter(Filter filter);

}
