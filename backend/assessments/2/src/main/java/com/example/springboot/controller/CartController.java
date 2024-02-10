package com.example.springboot.controller;

import com.example.springboot.model.Cart;
import com.example.springboot.model.Product;
import com.example.springboot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping("/cart")
    public ResponseEntity<String> createCart(@RequestBody Cart cart){
        cartService.createCart(cart);
        return new ResponseEntity<>("Cart created", HttpStatus.CREATED);
    }

    @PutMapping("/cart")
    public ResponseEntity<String> addProduct(@RequestParam String cartId, @RequestBody Product product){
        cartService.addProduct(Integer.parseInt(cartId), product);
        return new ResponseEntity<>("Product Added", HttpStatus.OK);
    }

    @DeleteMapping("/cart")
    public ResponseEntity<String> deleteProduct(@RequestParam String cartId, @RequestBody Product product){
        cartService.addProduct(Integer.parseInt(cartId), product);
        return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
    }
}
