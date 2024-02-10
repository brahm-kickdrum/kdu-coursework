package com.example.springboot.repository;

import com.example.springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "UPDATE Product p SET p.productName = :productName, p.description = :description, p.price = :price, p.stockQuantity = :stockQuantity WHERE p.productId = :productId")
    void updateProductDetails(
            @Param("productId")  Integer productId,
            @Param("productName") String productName,
            @Param("description") String description,
            @Param("price") Double price,
            @Param("stockQuantity") Integer stockQuantity
    );
}
