package com.bootcamp.springjpa.service;

import com.bootcamp.springjpa.entity.ProductEntity;
import com.bootcamp.springjpa.model.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAll();
    ProductEntity getById(Integer id);
    ProductEntity save(ProductDto request);
    ProductEntity delete(Integer id);
}
