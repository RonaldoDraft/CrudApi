package com.example.Spring.boot.controller;


import com.example.Spring.boot.dtos.ProductRecordDto;

import com.example.Spring.boot.models.ProductModel;
import com.example.Spring.boot.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.math.BigDecimal;

import java.util.UUID;

@ContextConfiguration(classes = {ProductController.class})
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductControllerTest {

//    @Test
//    void buscarProduct() throws Exception{
//        var product = new ProductModel();
//        product.setName("ak47");
//        Mockito.when(productRepository.findAll()).thenReturn(List.of(product));
//        this.mockMvc.perform(get("/product"))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//
//    }

    @InjectMocks
    private ProductController productController;

    @Autowired
    private ProductRepository productRepository;


    @Test
    void testSaveProduct() {
        ResponseEntity<ProductModel> response = productController.saveProduct(new ProductRecordDto("Name", BigDecimal.valueOf(42L)));
        Assertions.assertNotNull(response.getStatusCode());
    }
// return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));

    @Test
    void testSaveProductNull() {
        (new ProductController()).saveProduct(null);
    }


    @Test
    void testGetAllProducts() {
        (new ProductController()).getAllProducts();
    }

    @Test
    void testGetOneProduct() {
        ProductController productController = new ProductController();
        productController.getOneProduct(UUID.randomUUID());
    }

    @Test
    void testGetProductPerName() {
        (new ProductController()).getProductPerName("Name");
    }

    @Test
    void testUpdateProduct() {

        ProductController productController = new ProductController();
        UUID id = UUID.randomUUID();
        productController.updateProduct(id, new ProductRecordDto("Name", BigDecimal.valueOf(42L)));
    }

    @Test
    void testDeleteProduct() {

        ProductController productController = new ProductController();
        productController.deleteProduct(UUID.randomUUID());
    }

}










