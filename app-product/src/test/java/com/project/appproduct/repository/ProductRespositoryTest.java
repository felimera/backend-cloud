package com.project.appproduct.repository;

import com.project.appproduct.entity.Category;
import com.project.appproduct.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
class ProductRespositoryTest {
    @Autowired
    private ProductRespository productRespository;

    @Test
    void whenFindByCategoryThenReturnListProducto() {
        Product product01 = Product
                .builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.99"))
                .status("Created")
                .createAt(new Date())
                .build();

        productRespository.save(product01);

        List<Product> products = productRespository.findByCategory(product01.getCategory());
        assertThat(products).isNotNull();
        assertFalse(products.isEmpty());
    }
}