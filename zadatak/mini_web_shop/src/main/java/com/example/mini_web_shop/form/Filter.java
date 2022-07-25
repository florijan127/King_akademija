package com.example.mini_web_shop.form;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Filter {

    private String prodName;
    private String brandName;
    private double priceMax;
}
