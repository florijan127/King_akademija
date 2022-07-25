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
@Table(name = "NACIN_PLACANJA")
public class PayMeth {

    @Id
    @Column(name = "id_nacin_plac")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "naz_nacin_plac")
    private String name;
}
