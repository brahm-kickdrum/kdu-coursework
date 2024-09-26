package com.kdu.smarthome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListDeviceInventoryDto {
    private List<DeviceInventoryDto> inventory;
    private String httpStatus;
}
