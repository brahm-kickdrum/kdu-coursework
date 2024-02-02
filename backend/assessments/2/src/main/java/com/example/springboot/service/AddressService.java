package com.example.springboot.service;

import com.example.springboot.exception.custom.entityNotFoundException;
import com.example.springboot.model.Address;
import com.example.springboot.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AddressService {
    AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public void createAddress(Address address){
        if(address!=null){
            addressRepository.save(address);
            log.info("Address saved successfully");
        }
        else{
            throw new entityNotFoundException("Invalid Cart");
        }
    }
}
