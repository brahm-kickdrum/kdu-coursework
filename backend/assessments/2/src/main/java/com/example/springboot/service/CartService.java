package com.example.springboot.service;

import com.example.springboot.exception.custom.entityNotFoundException;
import com.example.springboot.model.Cart;
import com.example.springboot.model.Product;
import com.example.springboot.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CartService {
    CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public void createCart(Cart cart){
        if(cart!=null){
            cartRepository.save(cart);
            log.info("Cart created successfully");
        }
        else{
            throw new entityNotFoundException("Invalid Cart");
        }
    }

    public void addProduct(Integer cartId, Product product){
        if(product!=null){
            if(cartRepository.existsById(cartId)){
                List<Product> productList = cartRepository.getReferenceById(cartId).getProductList();
                productList.add(product);
                cartRepository.updateCart(cartId,productList);
                log.info("product added successfully");
            }
            else{
                throw new entityNotFoundException("Cart does not exist");
            }
        }
        else{
            throw new entityNotFoundException("Product is empty");
        }
    }

    public void deleteProduct(Integer cartId, Product product){
        if(product!=null){
            if(cartRepository.existsById(cartId)){
                List<Product> productList = cartRepository.getReferenceById(cartId).getProductList();
                productList.remove(product);
                cartRepository.updateCart(cartId,productList);
                log.info("product deleted successfully");
            }
            else{
                throw new entityNotFoundException("Cart does not exist");
            }
        }
        else{
            throw new entityNotFoundException("Product is empty");
        }
    }
}
