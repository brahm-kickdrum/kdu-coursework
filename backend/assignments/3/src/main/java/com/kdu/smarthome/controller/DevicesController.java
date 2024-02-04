package com.kdu.smarthome.controller;

import com.kdu.smarthome.dto.DeviceAddRequestDTO;
import com.kdu.smarthome.dto.DeviceRegisterRequestDto;
import com.kdu.smarthome.dto.DeviceRegisterResponseDto;
import com.kdu.smarthome.service.DevicesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevicesController {

    DevicesService devicesService;

    public DevicesController(DevicesService devicesService){
        this.devicesService = devicesService;
    }

    @PostMapping("/api/v1/device/register")
    public ResponseEntity<DeviceRegisterResponseDto> registerDevice(@RequestBody DeviceRegisterRequestDto requestDTO) {
        devicesService.registerDevice(requestDTO);
        DeviceRegisterResponseDto responseDTO = new DeviceRegisterResponseDto();
        responseDTO.setMessage("Device registered successfully");
        responseDTO.setObject("Additional information about the added item");
        responseDTO.setHttpStatus(HttpStatus.OK);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/api/v1/device/add")
    public ResponseEntity<DeviceRegisterResponseDto> addDeviceToHouse(@RequestBody DeviceAddRequestDTO requestDTO) {
        devicesService.addDeviceToHouse(requestDTO);
        DeviceRegisterResponseDto responseDTO = new DeviceRegisterResponseDto();
        responseDTO.setMessage("Device added to the house successfully");
        responseDTO.setObject("Additional information about the added item");
        responseDTO.setHttpStatus(HttpStatus.OK);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
