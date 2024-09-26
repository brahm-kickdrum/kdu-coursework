package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehicle {
    int id;
    String name;
    int price;
    String key;

    public Vehicle(int id, String name, int price, String key) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.key = key;
    }
}
