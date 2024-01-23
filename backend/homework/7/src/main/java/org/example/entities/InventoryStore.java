package org.example.entities;

import org.example.entities.Vehicle;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
//@Scope("prototype")
public class InventoryStore {

    private List<Vehicle> vehicles = new ArrayList<>();

    public void addToInventory(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getInventory() {
        return vehicles;
    }

    public Vehicle findHighestPricedVehicle() {
        return vehicles.stream()
                .max((v1, v2) -> Double.compare(v1.getPrice(), v2.getPrice()))
                .orElse(null);
    }

    public Vehicle findLowestPricedVehicle() {
        return vehicles.stream()
                .min((v1, v2) -> Double.compare(v1.getPrice(), v2.getPrice()))
                .orElse(null);
    }
}
