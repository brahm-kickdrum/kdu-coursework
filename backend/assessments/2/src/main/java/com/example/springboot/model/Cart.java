package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;

    @OneToOne
    private Buyer buyer;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> productList;
}
