package com.kdu.smarthome.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class DeviceRegisterResponseDto {
    private String message;
    private String object;
    private HttpStatus httpStatus;

}