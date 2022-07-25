package com.example.mini_web_shop.service.impl;

import com.example.mini_web_shop.dto.ItemDto;
import com.example.mini_web_shop.form.Filter;
import com.example.mini_web_shop.model.Item;
import com.example.mini_web_shop.repository.ItemRepository;
import com.example.mini_web_shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }


    @Override
    public List<Item> filter(Filter filter) {
        if (filter.getBrandName() == "" && filter.getProdName() == "" && filter.getPriceMax() == 0) {
            return itemRepository.findAll();
        }
        return itemRepository.filter(filter.getProdName(), filter.getBrandName(), filter.getPriceMax());
    }


}
