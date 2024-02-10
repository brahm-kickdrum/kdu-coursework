package com.example.springboot.controller;

import com.example.springboot.model.Product;
import com.example.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<String> postProduct(@RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<>("Product Added",HttpStatus.CREATED);
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> removeProduct(@RequestBody Integer productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product Removed",HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return new ResponseEntity<>("Product Updated",HttpStatus.OK);
    }
}
