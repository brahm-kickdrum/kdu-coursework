package com.example.springboot.service;

import com.example.springboot.exception.custom.entityNotFoundException;
import com.example.springboot.model.Buyer;
import com.example.springboot.repository.BuyerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BuyerService {
    BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository){
        this.buyerRepository = buyerRepository;
    }
    public void createBuyer(Buyer buyer){
        if(buyer!=null){
            buyerRepository.save(buyer);
            log.info("Buyer created successfully");
        }
        else{
            throw new entityNotFoundException("Invalid Buyer");
        }
    }
}
