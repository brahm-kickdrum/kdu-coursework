package com.kdu.caching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressResponseDto {
    String number;
    String name;
    String street;
    String region;
    String country;
    int postalCode;
}
