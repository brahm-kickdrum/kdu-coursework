package com.example.demo.service;
import com.example.demo.constants.Constants;
import com.example.demo.dto.VehicleRequestDTO;
import com.example.demo.dto.VehicleResponseDTO;
import com.example.demo.entity.Vehicle;
import com.example.demo.exceptions.customexceptions.ResourceNotFoundException;
import com.example.demo.logger.LoggerFile;
import com.example.demo.repository.FactoryInventory;
import org.apache.coyote.BadRequestException;
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

    public void addVehicleToInventory(VehicleRequestDTO vehicleDTO) throws BadRequestException {
        if(vehicleDTO == null){
            throw new BadRequestException(Constants.VEHICLE_EXCEPTION_MESSAGE);
        }
        else if(vehicleDTO.getName() == null){
            throw new BadRequestException("name not found");
        }
        else {
            Vehicle vehicle = DTOMapper.convertToVehicle(vehicleDTO);
            factory.addVehicle(vehicle);
            LoggerFile.logInfo("Vehicle added successfully");
        }
    }
    public VehicleResponseDTO getVehicleFromInventory(int id) {
        Optional<Vehicle> vehicleOptional = factory.getVehicleById(id);

        if (vehicleOptional.isPresent()) {
            return DTOMapper.convertToVehicleResponseDTO(vehicleOptional.get());
        }
        else {
            throw new ResourceNotFoundException("Vehicle with ID " + id + " not found");
        }
    }

    public void updateVehicleFromInventory(int id, VehicleRequestDTO updatedVehicleDTO){
        factory.updateVehicle(id,DTOMapper.convertToVehicle(updatedVehicleDTO));
        LoggerFile.logInfo("Vehicle updated successfully");
    }

    public void deleteVehicleFromInventory(VehicleRequestDTO vehicleDTO){
        if(vehicleDTO == null) throw new ResourceNotFoundException("Vehicle does not exist");
        factory.deleteVehicle(DTOMapper.convertToVehicle(vehicleDTO));
        LoggerFile.logInfo("Vehicle deleted successfully");
    }

    public VehicleResponseDTO findHighestPricedVehicle() {
        Vehicle vehicle = factory.getAllVehicles().stream()
                .max((v1, v2) -> Double.compare(v1.getPrice(), v2.getPrice()))
                .orElse(null);
        if(vehicle == null){
            throw new ResourceNotFoundException(Constants.VEHICLE_EXCEPTION_MESSAGE);
        }
        LoggerFile.logInfo("Highest priced vehicle fetched successfully");
        return DTOMapper.convertToVehicleResponseDTO(vehicle);
    }

    public VehicleResponseDTO findLowestPricedVehicle() {
        Vehicle vehicle =  factory.getAllVehicles().stream()
                .min((v1, v2) -> Double.compare(v1.getPrice(), v2.getPrice()))
                .orElse(null);
        if(vehicle == null){
            throw new ResourceNotFoundException(Constants.VEHICLE_EXCEPTION_MESSAGE);
        }
        LoggerFile.logInfo("Lowest priced vehicle fetched successfully");
        return DTOMapper.convertToVehicleResponseDTO(vehicle);
    }

}
