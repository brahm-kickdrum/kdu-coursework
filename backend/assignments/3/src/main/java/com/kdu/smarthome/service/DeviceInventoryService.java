package com.kdu.smarthome.service;

import com.kdu.smarthome.dto.DeviceInventoryRequestDto;
import com.kdu.smarthome.dto.DeviceInventoryResponseDto;
import com.kdu.smarthome.dto.DeviceResponseDto;
import com.kdu.smarthome.model.DeviceInventory;
import com.kdu.smarthome.repository.DeviceInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceInventoryService {
    DeviceInventoryRepository deviceInventoryRepository;

    @Autowired
    public DeviceInventoryService(DeviceInventoryRepository deviceInventoryRepository){
        this.deviceInventoryRepository = deviceInventoryRepository;
    }

    public DeviceInventoryResponseDto addItemToInventory(DeviceInventoryRequestDto requestDto) {
        LocalDateTime manufactureDateTime = LocalDateTime.parse(requestDto.getManufactureDateTime());

        DeviceInventory newItem = new DeviceInventory(
                requestDto.getKickstonId(),
                requestDto.getDeviceUsername(),
                requestDto.getDevicePassword(),
                manufactureDateTime,
                requestDto.getManufactureFactoryPlace()
        );

        deviceInventoryRepository.save(newItem);

        return new DeviceInventoryResponseDto("Item added to inventory successfully", newItem.getKickstonId(), "200 OK");
    }

    public List<DeviceResponseDto> getAllItems() {
        List<DeviceInventory> deviceInventoryList = deviceInventoryRepository.findAll();
        return deviceInventoryList.stream()
                .map(this::convertToDTO)
                .toList();
    }

    private DeviceResponseDto convertToDTO(DeviceInventory deviceInventory) {
        DeviceResponseDto dto = new DeviceResponseDto();
        dto.setKickstonId(deviceInventory.getKickstonId());
        dto.setDeviceUsername(deviceInventory.getDeviceUsername());
        dto.setDevicePassword(deviceInventory.getDevicePassword());
        dto.setManufactureDateTime(deviceInventory.getManufactureDateTime());
        dto.setManufactureFactoryPlace(deviceInventory.getManufactureFactoryPlace());
        return dto;
    }

}
