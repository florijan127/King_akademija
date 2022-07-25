package com.example.mini_web_shop.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ItemDto {

    private int id;
    private String name;
    private String description;
    private double price;
    private int inStock;
    private int brandId;
    private String brandName;
}