package com.example.demo.service;

import com.example.demo.dto.VehicleRequestDTO;
import com.example.demo.dto.VehicleResponseDTO;
import com.example.demo.entity.Vehicle;

public class DTOMapper {

    private DTOMapper(){}
    public static Vehicle convertToVehicle(VehicleRequestDTO vehicleRequestDTO){
        return new Vehicle(vehicleRequestDTO.getId(), vehicleRequestDTO.getName(), 1200000, "1234");
    }
    public static VehicleResponseDTO convertToVehicleResponseDTO(Vehicle vehicle){
        return new VehicleResponseDTO(vehicle.getId(), vehicle.getName(), 1200000);
    }
}