package com.kdu.smarthome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceInventoryDto {
    private String kickstoneId;
    private String deviceUsername;
    private String devicePassword;
}
