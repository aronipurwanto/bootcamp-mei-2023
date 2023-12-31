package com.ahmadroni.pos.service;

import com.ahmadroni.pos.entity.CategoryEntity;
import com.ahmadroni.pos.model.request.CategoryRequest;
import com.ahmadroni.pos.model.response.CategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryResponse> getAll();
    Optional<CategoryEntity> getById(Long id);
    Optional<CategoryEntity> getByCode(String code);
    Optional<CategoryEntity> save(CategoryRequest request);
    Optional<CategoryEntity> update(CategoryRequest request, Long id);
    Optional<CategoryEntity> delete(Long id);
}
