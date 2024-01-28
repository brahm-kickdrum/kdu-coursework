package com.kdu.caching.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    String number;
    String name;
    String street;
    String region;
    String country;
    int postalCode;
}
