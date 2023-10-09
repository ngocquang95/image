package com.example.image.service.impl;

import com.example.image.model.Product;
import com.example.image.repository.IProductRepository;
import com.example.image.repository.impl.ProductRepository;
import com.example.image.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }
}
