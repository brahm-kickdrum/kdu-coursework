package com.kdu.caching.service;

import com.kdu.caching.dto.AddressResponseDto;
import com.kdu.caching.dto.CoordinatesResponseDto;
import com.kdu.caching.entities.Address;
import com.kdu.caching.entities.Coordinates;

public class DtoMapper {
    private DtoMapper(){}

    /**
     * convertToCoordinateResponseDto converts Coordinates object to CoordinateResponseDto
     * @param coordinates Coordinates of a location
     * @return CoordinatesResponseDto
     */
    public static CoordinatesResponseDto convertToCoordinateResponseDto(Coordinates coordinates){
        return new CoordinatesResponseDto(coordinates.getLatitude(), coordinates.getLongitude());
    }

    /**
     * convertToAddressResponseDto converts Address object to AddressResponseDto
     * @param address Address of a location
     * @return AddressResponseDto
     */
    public static AddressResponseDto convertToAddressResponseDto(Address address){
        return new AddressResponseDto(address.getNumber(),address.getName(), address.getStreet(), address.getRegion(), address.getCountry(), address.getPostalCode());
    }
}
