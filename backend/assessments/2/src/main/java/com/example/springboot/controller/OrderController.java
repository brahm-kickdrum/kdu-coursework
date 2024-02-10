package com.example.springboot.controller;

import com.example.springboot.model.Orders;
import com.example.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<String> postOrder(@RequestBody Orders order){
        orderService.placeOrder(order);
        return new ResponseEntity<>("Order posted", HttpStatus.OK);
    }
}
