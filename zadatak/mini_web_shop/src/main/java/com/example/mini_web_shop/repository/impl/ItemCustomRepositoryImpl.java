package com.example.mini_web_shop.repository.impl;

import com.example.mini_web_shop.dto.ItemDto;
import com.example.mini_web_shop.model.Item;
import com.example.mini_web_shop.repository.ItemCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class ItemCustomRepositoryImpl implements ItemCustomRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Item> filter(String prodName, String brandName, Double maxPrice) {
        StringBuilder query = new StringBuilder("select i FROM Item i WHERE ");
        if (prodName != "") {
            query.append("UPPER(i.name) LIKE UPPER('%").append(prodName).append("%')");
            if (brandName != "") {
                query.append(" AND UPPER(i.brand.name) LIKE UPPER('%").append(brandName).append("%')");
            }
            if (maxPrice != 0) {
                query.append(" AND i.price <= ").append(maxPrice);
            }
        } else if (brandName != "") {
            query.append("UPPER(i.brand.name) LIKE UPPER('%").append(brandName).append("%')");
            if (maxPrice != 0) {
                query.append(" AND i.price <= ").append(maxPrice);
            }
        } else query.append("i.price <= ").append(maxPrice);

        return entityManager.createQuery(query.toString(), Item.class).getResultList();

//
//        List<Object[]> list = entityManager.createNativeQuery(query.toString()).getResultList();
//        return list.stream().map(object -> ItemDto.builder().id((Integer) object[0]).build()).collect(Collectors.toList());
    }
}


