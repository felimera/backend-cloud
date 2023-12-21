package com.project.appproduct.service.implementation;

import com.project.appproduct.entity.Category;
import com.project.appproduct.entity.Product;
import com.project.appproduct.repository.ProductRespository;
import com.project.appproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRespository productRespository;

    @Override
    public List<Product> listAllProduct() {
        return productRespository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRespository.findById(id).orElse(null);
    }

    @Override
    public Product createdProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(new Date());
        return productRespository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product productDb = getProduct(id);
        if (Objects.isNull(productDb))
            return null;

        productDb.setName(product.getName());
        productDb.setStatus(product.getStatus());
        productDb.setPrice(product.getPrice());
        productDb.setCategory(product.getCategory());
        productDb.setDescription(product.getDescription());
        productDb.setStock(product.getStock());
        return productRespository.save(productDb);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productDb = getProduct(id);
        if (Objects.isNull(productDb))
            return null;
        productDb.setStatus("DELETED");
        return productRespository.save(productDb);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRespository.findByCategory(category);
    }

    @Override
    public Product updateShock(Long id, Double quantity) {
        Product productDb = getProduct(id);
        if (Objects.isNull(productDb))
            return null;
        Double stock = productDb.getStock() + quantity;
        productDb.setStock(stock);
        return productRespository.save(productDb);
    }
}
