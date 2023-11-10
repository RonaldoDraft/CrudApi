package com.example.Spring.boot.controller;

import com.example.Spring.boot.dtos.ProductRecordDto;

import java.math.BigDecimal;
import java.util.*;


import com.example.Spring.boot.models.ProductModel;
import com.example.Spring.boot.repositories.ProductRepository;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.ValidatableMockMvcResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@WebMvcTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    private ProductModel productModel1;

    private UUID uuid = UUID.randomUUID();

    private Map<String,String> param;

    private String json;

    @Autowired
    private MockMvc mvc;
    private ProductRecordDto productRecordDto;

    @MockBean
    private ProductRepository productRepository;

    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.standaloneSetup(this.productController);
        this.productModel1 = new ProductModel(uuid,"zhonyas",new BigDecimal(42) ,"GOLD","item") ;
        this.productRecordDto = new ProductRecordDto("zhonyas",new BigDecimal(42) ,"item","GOLD");
        this.json = "{\"name\":\"zhonyas\",\"value\":\"42\"" +
                ",\"moeda\":\"GOLD\",\"tipe\":\"Item\"}";
        this.param = new HashMap<>();
        this.param.put("name","zhonyas");
        this.param.put("value","42");
        this.param.put("tipe","item");
        this.param.put("moeda","GOLD");
    }

    @Test
    void mustSaveProduct_WhenPost() {
        when(this.productRepository.save(any())).thenReturn(this.productModel1);
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(this.param)
                .when()
                .post("/products")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("name",equalTo("zhonyas"))
                .body("value",equalTo(42))
                .body("tipe",equalTo("item"))
                .body("moeda",equalTo("GOLD"));

    }


    @Test
    void mustGetAllProducts_WhenGetAll() {
        List<ProductModel> list = new ArrayList<>();
        list.add(this.productModel1);
        when(this.productRepository.findAll()).thenReturn(list);
        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .when()
                .get("/products")
                .then()
                .statusCode(HttpStatus.OK.value());

    }


    @Test
    void mustGetOneProductById_WhenGetById() {
        when(this.productRepository.findById(this.uuid)).thenReturn(Optional.ofNullable(productModel1));
        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .when()
                .get("/products/" + this.uuid)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void mustNotGetOneProductById_WhenGetByIdBecauseNotFound() {
        when(this.productRepository.findById(UUID.randomUUID())).thenReturn(Optional.ofNullable(productModel1));
        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .when()
                .get("/products/" + this.uuid)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void mustGetProductPerName_WhenGetByName() {
        when(this.productRepository.findByName(this.param.get("name"))).thenReturn(Optional.ofNullable(productModel1));
        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .when()
                .get("/products/name/" + this.param.get("name"))
                .then()
                .statusCode(HttpStatus.OK.value());
    }
    @Test
    void mustNotGetProductPerName_WhenGetByNameBecauseNotFound() {
        when(this.productRepository.findByName("al")).thenReturn(Optional.ofNullable(productModel1));
        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .when()
                .get("/products/name/" + this.param.get("name"))
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }


    @Test
    void mustUpdateProduct_WhenPut() {
        when(this.productRepository.save(any())).thenReturn(this.productModel1);
        ValidatableMockMvcResponse response = RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(this.param)
                .when()
                .post("/products")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("name",equalTo("zhonyas"))
                .body("value",equalTo(42))
                .body("tipe",equalTo("item"))
                .body("moeda",equalTo("GOLD"));
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(this.param)
                .when()
                .put("/products" + this.uuid)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void mustDeleteProduct_WhenDelete() {
        when(this.productRepository.findById(this.uuid)).thenReturn(Optional.ofNullable(productModel1));
        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .when()
                .delete("/products/" + this.uuid)
                .then()
                .statusCode(HttpStatus.OK.value());
    }
    @Test
    void mustNotDeleteProduct_WhenDeleteBecauseNotFound() {
        when(this.productRepository.findById(UUID.randomUUID())).thenReturn(Optional.ofNullable(productModel1));
        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .when()
                .delete("/products/" + this.uuid)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
}

