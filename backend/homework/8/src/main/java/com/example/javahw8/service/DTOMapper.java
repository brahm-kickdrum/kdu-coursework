package com.example.javahw8.service;

import com.example.javahw8.dto.VehicleDTO;
import com.example.javahw8.entity.Vehicle;

public class DTOMapper {

    private DTOMapper(){}
    public static VehicleDTO convertToDTO(Vehicle vehicle) {
        return new VehicleDTO(vehicle.getId(), vehicle.getName(), vehicle.getPrice());
    }

    public static Vehicle convertToEntity(VehicleDTO vehicleDTO) {
        return new Vehicle(vehicleDTO.getId(), vehicleDTO.getName(), vehicleDTO.getPrice());
    }
}