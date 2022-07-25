package com.example.mini_web_shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "NARUDZBA")
public class Order {

    @Id
    @Column(name = "id_nar")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "datum_nar")
    private LocalDate dateTime;

    @Column(name = "uk_cijena_bez_p")
    private double priceWOTax;

    @Column(name = "uk_cijena_s_p")
    private double priceWTax;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_popust_kod", referencedColumnName = "id_popust_kod")
    private Coupon coupon;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_nacin_plac", referencedColumnName = "id_nacin_plac")
    private PayMeth payMeth;

    @Column(name = "br_kartice")
    private String cardNo;

    @Column(name = "email")
    private String email;

    @Column(name = "br_mob")
    private int phoneNo;

    @Column(name = "adr_dostave")
    private String address;

    @Column(name = "napomena")
    private String instructions;

    @ManyToMany
    @JoinTable(
            name = "NARUDZBA_PROIZVODI",
            joinColumns = @JoinColumn(name = "id_nar"),
            inverseJoinColumns = @JoinColumn(name = "id_pro"))
    List<Item> orderedItems;
}