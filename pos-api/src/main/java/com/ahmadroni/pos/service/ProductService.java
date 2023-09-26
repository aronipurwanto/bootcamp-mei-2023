package com.ahmadroni.pos.service;

import com.ahmadroni.pos.entity.ProductEntity;
import com.ahmadroni.pos.model.request.ProductRequest;
import com.ahmadroni.pos.model.response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponse> getAll();
    Optional<ProductResponse> getById(Long id);
    Optional<ProductResponse> getByCode(String code);
    Optional<ProductEntity> save(ProductRequest request);
    Optional<ProductEntity> update(ProductRequest request, Long id);
    Optional<ProductEntity> delete(Long id);
}
