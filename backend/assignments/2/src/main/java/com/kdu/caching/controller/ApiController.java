package com.kdu.caching.controller;

import com.kdu.caching.dto.AddressResponseDto;
import com.kdu.caching.dto.CoordinatesResponseDto;
import com.kdu.caching.entities.Address;
import com.kdu.caching.entities.Coordinates;
import com.kdu.caching.exceptions.customexceptions.InvalidAddressException;
import com.kdu.caching.service.GeoCodeService;
import com.kdu.caching.service.DtoMapper;
import com.kdu.caching.service.ReverseGeoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {
    private GeoCodeService geocodeService = new GeoCodeService();
    private ReverseGeoCodeService reverseGeocodeService = new ReverseGeoCodeService();

    @Autowired
    public ApiController(GeoCodeService geocodeService, ReverseGeoCodeService reverseGeocodeService){
        this.geocodeService = geocodeService;
        this.reverseGeocodeService = reverseGeocodeService;
    }

    /**
     * @param address Address of a location
     * @return CoordinateResponseDto
     */
    @GetMapping("/geocoding")
    public ResponseEntity<CoordinatesResponseDto> getGeocode(@RequestParam String address) throws InvalidAddressException {
        Coordinates coordinates = geocodeService.fetchGeocodeData(address);
        return ResponseEntity.ok(DtoMapper.convertToCoordinateResponseDto(coordinates));
    }

    /**
     * @param latitude Latitude of a location
     * @param longitude Longitude of a location
     * @return Plot number
     */
    @GetMapping("/reverse-geocoding")
    public String getReverseGeocode(@RequestParam Double latitude, @RequestParam Double longitude){
        Address address = reverseGeocodeService.fetchReverseGeocodeData(latitude, longitude);
        AddressResponseDto addressResponseDto = DtoMapper.convertToAddressResponseDto(address);
        return addressResponseDto.getNumber();
    }
}
