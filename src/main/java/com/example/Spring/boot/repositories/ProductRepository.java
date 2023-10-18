package com.example.Spring.boot.repositories;

import com.example.Spring.boot.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

    Optional<ProductModel> findByName(String name);
}
