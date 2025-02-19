package com.example.springboot.service;

import com.example.springboot.exception.custom.entityNotFoundException;
import com.example.springboot.model.Orders;
import com.example.springboot.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {
    OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public void placeOrder(Orders order){
        if(order!=null){
            orderRepository.save(order);
            log.info("Buyer created successfully");
        }
        else{
            throw new entityNotFoundException("Invalid Buyer");
        }
    }

}
