package com.bootcamp.springjpa.service;

import com.bootcamp.springjpa.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAll();
}
