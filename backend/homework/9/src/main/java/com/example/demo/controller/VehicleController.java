package com.example.demo.controller;

import com.example.demo.dto.VehicleRequestDTO;
import com.example.demo.dto.VehicleResponseDTO;
import com.example.demo.service.VehicleService;
import org.apache.coyote.BadRequestException;
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

    @PostMapping("/vehicle")
    public ResponseEntity<String> addVehicle(@RequestBody VehicleRequestDTO vehicleDTO) throws BadRequestException {
        vehicleService.addVehicleToInventory(vehicleDTO);
        return ResponseEntity.ok("Vehicle added successfully");
    }

    @GetMapping("/vehicle/{id}")
    public VehicleResponseDTO getVehicle(@PathVariable int id){
        return vehicleService.getVehicleFromInventory(id);

    }

    @PutMapping("/vehicle/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable int id, @RequestBody VehicleRequestDTO vehicleDTO){
        vehicleService.updateVehicleFromInventory(id, vehicleDTO);
        return ResponseEntity.ok("Vehicle updated successfully");
    }

    @DeleteMapping("/Vehicle")
    public ResponseEntity<String> deleteVehicle(@RequestBody VehicleRequestDTO vehicleDTO){
        vehicleService.deleteVehicleFromInventory(vehicleDTO);
        return ResponseEntity.ok("Vehicle deleted successfully");
    }

    @GetMapping("/{type}")
    public String showMaxOrMinPrice(@PathVariable String type)
    {
        if(type.equals("Highest"))
            return "highest = " + vehicleService.findHighestPricedVehicle();
        else
            return "lowest = " + vehicleService.findLowestPricedVehicle();
    }

}
