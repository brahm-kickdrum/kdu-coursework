package com.example.javahw8.repository;
import com.example.javahw8.dto.VehicleDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FactoryInventory {

    private List<VehicleDTO> inventory = new ArrayList<>();

    /**
     * addVehicle function adds Vehicle to inventory
     * @param vehicle
     */
    public void addVehicle(VehicleDTO vehicle) {
        if (vehicle != null && !inventory.contains(vehicle)) {
            inventory.add(vehicle);
        }
    }

    /**
     * deleteVehicle function deletes Vehicle from inventory
     * @param vehicle
     */
    public void deleteVehicle(VehicleDTO vehicle) {
        if (vehicle != null) {
            inventory.remove(vehicle);
        }
    }

    /**
     * getVehicleById gets the vehicle object by id
     * @param id
     * @return
     */
    public Optional<VehicleDTO> getVehicleById(int id) {
        return inventory.stream()
                .filter(v -> v.getId()==(id))
                .findFirst();
    }

    /**
     * updateVehicle
     * @param id
     * @param updatedVehicle
     */
    public void updateVehicle(int id, VehicleDTO updatedVehicle) {
        if (updatedVehicle != null) {
            for (VehicleDTO existingVehicle : inventory) {
                if (existingVehicle.getId() == (id)) {
                    existingVehicle.setName(updatedVehicle.getName());
                    existingVehicle.setPrice(updatedVehicle.getPrice());
                    break;
                }
            }
        }
    }

    public List<VehicleDTO> getAllVehicles(){
        return inventory;
    }
}
