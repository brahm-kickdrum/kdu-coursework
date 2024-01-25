package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleResponseDTO {
    int id;
    String name;
    int price;

    public VehicleResponseDTO(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
