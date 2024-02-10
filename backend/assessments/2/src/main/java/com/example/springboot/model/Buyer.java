package com.example.springboot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer buyerId;

    private String name;

    private String email;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> addresses;
}

