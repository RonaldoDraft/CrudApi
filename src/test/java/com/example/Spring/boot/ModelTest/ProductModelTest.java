package com.example.Spring.boot.ModelTest;

import com.example.Spring.boot.models.ProductModel;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.assertEquals;


@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductModelTest {

    ProductModel productModel;


//    public ProductModelTest(){
//
//        productModel.setIdproduct(UUID.fromString("teste"));
//        productModel.setName("teste");
//        productModel.setValue(BigDecimal.valueOf(27000));
//    }
//    @Test
//    public void productModelNotNull(){
//        Assertions.assertThat(productModel.getName().isEqualTo("ak47"));
//
//    }

    @Test
    public void UserTest() {
        ProductModel product = new ProductModel(UUID.fromString("8184a512-7ead-4ded-b968-7d160ba1cf33"),"Ak47", BigDecimal.valueOf(2000.00));
        assertEquals("Ak47", product.getName());
    }

}
