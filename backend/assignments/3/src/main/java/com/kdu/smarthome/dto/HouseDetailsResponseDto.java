package com.kdu.smarthome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HouseDetailsResponseDto {
    private String message;
    private String roomsAndDevices;
    private String httpStatus;
}
