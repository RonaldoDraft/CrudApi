package com.example.Spring.boot.RepositoryTest;


import com.example.Spring.boot.models.ProductModel;
import com.example.Spring.boot.repositories.ProductRepository;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;


@DataJpaTest
@DisplayName("testes para repositorio")
public class RespositoryTest {

    @Mock
    ProductRepository productRepository;


    @Test
    @DisplayName("teste para repositorio")
    public void salvarNoBanco_WhenSucessful() {
        ProductModel productToBeSaved = new ProductModel();
        productToBeSaved.setName("teste");
        ProductModel productSaved = this.productRepository.save(productToBeSaved);
        Assertions.assertThat(productSaved).isNotNull();
        Assertions.assertThat(productToBeSaved).isEqualTo(productSaved);

    }

}
