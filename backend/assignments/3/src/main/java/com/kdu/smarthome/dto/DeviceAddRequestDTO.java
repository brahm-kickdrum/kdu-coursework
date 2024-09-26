package com.kdu.smarthome.dto;

import lombok.Data;

@Data
public class DeviceAddRequestDTO {
    private String houseId;
    private String roomId;
    private String kickstonId;
}
