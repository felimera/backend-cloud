package com.project.appproduct.controller;

import com.project.appproduct.entity.Product;
import com.project.appproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<Product>> listProduct() {
        List<Product> products = productService.listAllProduct();
        if (products.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }
}
