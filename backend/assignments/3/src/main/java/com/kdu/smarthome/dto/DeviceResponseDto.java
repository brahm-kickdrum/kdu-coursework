package com.kdu.smarthome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceResponseDto {
    private String kickstonId;
    private String deviceUsername;
    private String devicePassword;
    private LocalDateTime manufactureDateTime;
    private String manufactureFactoryPlace;
}
