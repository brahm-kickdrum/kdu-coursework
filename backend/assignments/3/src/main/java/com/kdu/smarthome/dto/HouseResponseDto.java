package com.kdu.smarthome.dto;

import com.kdu.smarthome.model.Houses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseResponseDto {
    private String message;
    private List<Houses> houses;
    private String httpStatus;
}
