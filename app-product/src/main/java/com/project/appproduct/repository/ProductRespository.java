package com.project.appproduct.repository;

import com.project.appproduct.entity.Category;
import com.project.appproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRespository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
