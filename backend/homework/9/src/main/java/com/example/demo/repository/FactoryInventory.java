package com.example.demo.repository;
import com.example.demo.entity.Vehicle;
import com.example.demo.logger.LoggerFile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FactoryInventory {

    private List<Vehicle> inventory = new ArrayList<>();

    /**
     * addVehicle function adds Vehicle to inventory
     * @param vehicle
     */
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    /**
     * deleteVehicle function deletes Vehicle from inventory
     * @param vehicle
     */
    public void deleteVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    /**
     * getVehicleById gets the vehicle object by id
     * @param id
     * @return
     */
    public Optional<Vehicle> getVehicleById(int id) {
        return inventory.stream()
                .filter(v -> v.getId()==(id))
                .findFirst();
    }

    /**
     * updateVehicle
     * @param id
     * @param updatedVehicle
     */
    public void updateVehicle(double id, Vehicle updatedVehicle) {
        inventory.stream()
                .filter(existingVehicle -> existingVehicle.getId() == (id))
                .findFirst()
                .ifPresent(existingVehicle -> {
                    existingVehicle.setName(updatedVehicle.getName());
                    existingVehicle.setPrice(updatedVehicle.getPrice());
                });
    }

    public List<Vehicle> getAllVehicles(){
        LoggerFile.logInfo("Vehicle updated successfully");
        return inventory;
    }
}
