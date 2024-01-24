package com.example.javahw8.controller;

import com.example.javahw8.dto.VehicleDTO;
import com.example.javahw8.entity.Vehicle;
import com.example.javahw8.service.DTOMapper;
import com.example.javahw8.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/post")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle){
        vehicleService.addVehicleToInventory(DTOMapper.convertToDTO(vehicle));
        return ResponseEntity.ok("Vehicle added successfully");
    }

    @GetMapping("/get/{id}")
    public Vehicle getVehicle(@PathVariable int id){
        VehicleDTO vehicleDTO = vehicleService.getVehicleFromInventory(id);
        return DTOMapper.convertToEntity(vehicleDTO);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle){
        vehicleService.updateVehicleFromInventory(id, DTOMapper.convertToDTO(vehicle));
        return ResponseEntity.ok("Vehicle updated successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteVehicle(@RequestBody Vehicle vehicle){
        vehicleService.deleteVehicleFromInventory(DTOMapper.convertToDTO(vehicle));
        return ResponseEntity.ok("Vehicle deleted successfully");
    }

    @GetMapping("/factory1/showprice/{type}")
    public String showMaxOrMinPrice(@PathVariable String type)
    {
        if(type.equals("Highest"))
            return "highest = " + vehicleService.findHighestPricedVehicle();
        else
            return "lowest = " + vehicleService.findLowestPricedVehicle();
    }

}
