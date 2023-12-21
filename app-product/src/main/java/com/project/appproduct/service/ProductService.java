package com.project.appproduct.service;

import com.project.appproduct.entity.Category;
import com.project.appproduct.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> listAllProduct();

    Product getProduct(Long id);

    Product createdProduct(Product product);

    Product updateProduct(Long id, Product product);

    Product deleteProduct(Long id);

    List<Product> findByCategory(Category category);

    Product updateShock(Long id, Double quantity);
}
