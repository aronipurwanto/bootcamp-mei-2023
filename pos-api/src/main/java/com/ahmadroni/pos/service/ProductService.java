package com.ahmadroni.pos.service;

import com.ahmadroni.pos.entity.ProductEntity;
import com.ahmadroni.pos.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> getAll();
    Optional<ProductEntity> getById(Long id);
    Optional<ProductEntity> getByCode(String code);
    Optional<ProductEntity> save(ProductModel request);
    Optional<ProductEntity> update(ProductModel request, Long id);
    Optional<ProductEntity> delete(Long id);
}
