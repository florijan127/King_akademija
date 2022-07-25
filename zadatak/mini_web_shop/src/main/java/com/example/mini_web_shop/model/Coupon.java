package com.example.mini_web_shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "POPUST_KODOVI")
public class Coupon {

    @Id
    @Column(name = "id_popust_kod")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "popust_kod")
    private String code;
    @Column(name = "popust")
    private double discount;
    @Column(name = "iskoristen")
    private Boolean used;
}
