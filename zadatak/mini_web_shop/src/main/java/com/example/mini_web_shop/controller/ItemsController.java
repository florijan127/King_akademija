package com.example.mini_web_shop.controller;

import com.example.mini_web_shop.dto.ItemDto;
import com.example.mini_web_shop.form.Filter;
import com.example.mini_web_shop.model.Item;
import com.example.mini_web_shop.service.ItemService;
import com.example.mini_web_shop.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/items")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    ResponseEntity<List<Item>> findAll() {
        return ResponseEntity.ok().body(itemService.findAll());
    }


    @PostMapping (value = "/filter")
    ResponseEntity<List<Item>> filter(@RequestBody Filter filter) {
        return ResponseEntity.ok().body(itemService.filter(filter));
    }


}
