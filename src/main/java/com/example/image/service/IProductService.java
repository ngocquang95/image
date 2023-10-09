package com.example.image.service;

import com.example.image.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void create(Product product);
}
