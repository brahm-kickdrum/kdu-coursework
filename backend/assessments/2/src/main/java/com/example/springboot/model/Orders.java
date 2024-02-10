package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @OneToOne
    private Buyer buyer;

    private LocalDate orderDate;

    private Double amount;

    @OneToOne(fetch = FetchType.EAGER)
    private Address address;

    @OneToOne(fetch = FetchType.EAGER)
    private Cart cart;

}
