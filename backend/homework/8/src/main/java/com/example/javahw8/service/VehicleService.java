package com.example.javahw8.service;
import com.example.javahw8.dto.VehicleDTO;
import com.example.javahw8.repository.FactoryInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VehicleService {
    private FactoryInventory factory = new FactoryInventory();

    @Autowired
    public VehicleService(FactoryInventory factory) {
        this.factory = factory;
    }

    public void addVehicleToInventory(VehicleDTO vehicle){
        factory.addVehicle(vehicle);
    }
    public VehicleDTO getVehicleFromInventory(int id) {
        Optional<VehicleDTO> vehicleDTOOptional = factory.getVehicleById(id);

        if (vehicleDTOOptional.isPresent()) {
            return vehicleDTOOptional.get();
        }
        else {
            throw new NoSuchElementException("Vehicle with ID " + id + " not found");
        }
    }

    public void updateVehicleFromInventory(int id, VehicleDTO updatedVehicle){
        factory.updateVehicle(id,updatedVehicle);
    }

    public void deleteVehicleFromInventory(VehicleDTO vehicle){
        factory.deleteVehicle(vehicle);
    }

    public VehicleDTO findHighestPricedVehicle() {
        return factory.getAllVehicles().stream()
                .max((v1, v2) -> Double.compare(v1.getPrice(), v2.getPrice()))
                .orElse(null);
    }

    public VehicleDTO findLowestPricedVehicle() {
        return factory.getAllVehicles().stream()
                .min((v1, v2) -> Double.compare(v1.getPrice(), v2.getPrice()))
                .orElse(null);
    }

}
