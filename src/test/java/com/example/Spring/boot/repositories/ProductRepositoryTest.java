package com.example.Spring.boot.repositories;

import com.example.Spring.boot.models.ProductModel;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {ProductRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.example.Spring.boot.models"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;


}

