package com.example.image.repository;

import com.example.image.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void create(Product product);
}
