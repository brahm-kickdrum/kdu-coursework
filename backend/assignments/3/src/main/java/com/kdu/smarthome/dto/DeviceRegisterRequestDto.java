package com.kdu.smarthome.dto;

import lombok.Data;

@Data
public class DeviceRegisterRequestDto {
    private String kickstonId;
    private String deviceUsername;
    private String devicePassword;
}