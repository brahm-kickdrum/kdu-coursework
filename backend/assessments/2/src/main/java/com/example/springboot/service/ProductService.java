package com.example.springboot.service;

import com.example.springboot.exception.custom.entityNotFoundException;
import com.example.springboot.model.Product;
import com.example.springboot.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void addProduct(Product product){
        if(product!=null){
            productRepository.save(product);
            log.info("product added successfully");
        }
        else{
            throw new entityNotFoundException("Product is empty");
        }
    }

    public void deleteProduct(int productId){
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
        }
        else{
            throw new entityNotFoundException("Product does not exist");
        }
    }

    public void updateProduct(Product product){
        if(product!=null){
            productRepository.updateProductDetails(product.getProductId(), product.getProductName(), product.getDescription(), product.getPrice(), product.getStockQuantity());
            log.info("product updated successfully");
        }
        else{
            throw new entityNotFoundException("Product is empty");
        }
    }
}
