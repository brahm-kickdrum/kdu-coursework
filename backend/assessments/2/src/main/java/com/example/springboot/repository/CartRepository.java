package com.example.springboot.repository;

import com.example.springboot.model.Cart;
import com.example.springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query(value = "UPDATE Cart c SET c.productList = :productList WHERE c.cartId = :cartId")
    void updateCart(
            @Param("cartId")  Integer cartId,
            @Param("productList") List<Product> productList
    );
}
