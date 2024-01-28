package com.kdu.caching.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinates {
    double latitude;
    double longitude;
    String region;
}
