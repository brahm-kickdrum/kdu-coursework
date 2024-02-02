package com.example.springboot.controller;

import com.example.springboot.model.Buyer;
import com.example.springboot.model.Cart;
import com.example.springboot.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {

    BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService){
        this.buyerService = buyerService;
    }

    @PostMapping("/buyer")
    public ResponseEntity<String> createBuyer(@RequestBody Buyer buyer){
        buyerService.createBuyer(buyer);
        return new ResponseEntity<>("Cart created", HttpStatus.CREATED);
    }


}
