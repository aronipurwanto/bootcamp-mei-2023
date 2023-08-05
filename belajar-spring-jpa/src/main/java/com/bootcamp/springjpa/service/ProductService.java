package com.bootcamp.springjpa.service;

import com.bootcamp.springjpa.entity.ProductEntity;
import com.bootcamp.springjpa.model.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAll();
    ProductEntity save(ProductDto request);
}
