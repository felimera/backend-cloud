package com.project.appproduct.service.implementation;

import com.project.appproduct.entity.Category;
import com.project.appproduct.entity.Product;
import com.project.appproduct.repository.ProductRespository;
import com.project.appproduct.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
class ProductServiceImplTest {
    @Mock
    private ProductRespository productRespository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductServiceImpl(productRespository);

        Product computer = Product
                .builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("5"))
                .price(Double.parseDouble("12.5"))
                .status("Created")
                .createAt(new Date())
                .build();

        Mockito
                .when(productRespository.findById(1L))
                .thenReturn(Optional.of(computer));

        Mockito.when(productRespository.save(computer)).thenReturn(computer);
    }

    @Test
    void whenValidGetIdThenReturnProduct() {
        Product product = productService.getProduct(1L);
        Assertions.assertThat(product.getName()).isEqualTo("computer");
    }

    @Test
    void whenValidUpdateStockThenReturnNewStock() {
        Product newStock = productService.updateShock(1L, Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }
}