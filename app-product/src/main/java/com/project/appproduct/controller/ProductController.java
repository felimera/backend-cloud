package com.project.appproduct.controller;

import com.project.appproduct.entity.Category;
import com.project.appproduct.entity.Product;
import com.project.appproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProduct(@RequestParam(name = "categoryId", required = false) Long categoryId) {
        List<Product> products;
        if (Objects.isNull(categoryId)) {
            products = productService.listAllProduct();
            if (products.isEmpty())
                return ResponseEntity.noContent().build();
        } else {
            products = productService.findByCategory(Category.builder().id(categoryId).build());
            if (products.isEmpty())
                return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(products);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "id") Long id) {
        Product product = productService.getProduct(id);
        if (Objects.isNull(product))
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product productCreated = productService.createdProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreated);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(name = "id") Long id, @RequestBody Product product) {
        Product productUpdate = productService.updateProduct(id, product);
        if (Objects.isNull(productUpdate))
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(productUpdate);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(name = "id") Long id) {
        Product productDelete = productService.deleteProduct(id);
        if (Objects.isNull(productDelete))
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(productDelete);
    }


    @PutMapping(path = "/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable(name = "id") Long id, @RequestParam Double quantity) {
        Product productUpdate = productService.updateShock(id, quantity);
        if (Objects.isNull(productUpdate))
            return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.OK).body(productUpdate);
    }
}
