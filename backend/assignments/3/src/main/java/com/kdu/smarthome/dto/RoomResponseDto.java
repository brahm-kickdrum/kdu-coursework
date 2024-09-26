package com.kdu.smarthome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomResponseDto {
    private String message;
    private String object;
    private String httpStatus;
}
