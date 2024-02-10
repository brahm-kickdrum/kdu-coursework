package com.example.springboot.controller;

import com.example.springboot.model.Address;
import com.example.springboot.model.Cart;
import com.example.springboot.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    AddressService addressService;
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }
    @PostMapping("/address")
    public ResponseEntity<String> createAddresses(@RequestBody Address address){
        addressService.createAddress(address);
        return new ResponseEntity<>("Address created", HttpStatus.CREATED);
    }
}
