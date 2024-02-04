package com.kdu.smarthome.controller;

import com.kdu.smarthome.dto.DeviceInventoryDto;
import com.kdu.smarthome.dto.DeviceInventoryRequestDto;
import com.kdu.smarthome.dto.DeviceInventoryResponseDto;
import com.kdu.smarthome.dto.DeviceResponseDto;
import com.kdu.smarthome.service.DeviceInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceInventoryController {
    DeviceInventoryService deviceInventoryService;

    @Autowired
    public DeviceInventoryController(DeviceInventoryService deviceInventoryService){
        this.deviceInventoryService = deviceInventoryService;
    }

    @PostMapping("/api/v1/inventory")
    public ResponseEntity<DeviceInventoryResponseDto> addItemToInventory(@RequestBody DeviceInventoryRequestDto requestDto) {
        DeviceInventoryResponseDto responseDto = deviceInventoryService.addItemToInventory(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @GetMapping
    public List<DeviceResponseDto> getAllItems() {
        return deviceInventoryService.getAllItems();
    }

}
