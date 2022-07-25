package com.example.mini_web_shop.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "PROIZVOD")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "naziv_pro")
    private String name;

    @Column(name = "opis_pro")
    private String description;

    @Column(name = "cijena_pro")
    private Double price;

    @Column(name = "kolicina_pro")
    private Integer inStock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_brand")
    private Brand brand;

//    @ManyToMany(mappedBy = "orderedItems")
//    Set<Order> narudzbe;
}
