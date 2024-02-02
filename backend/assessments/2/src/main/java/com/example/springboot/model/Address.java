package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;

    private String nickName;

    private String street;

    private String city;

    private String state;

    private String postalCode;
}
