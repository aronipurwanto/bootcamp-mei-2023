package com.ahmadroni.pos.service.impl;

import com.ahmadroni.pos.entity.CategoryEntity;
import com.ahmadroni.pos.model.CategoryModel;
import com.ahmadroni.pos.repository.CategoryRepo;
import com.ahmadroni.pos.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public List<CategoryEntity> getAll() {
        return this.categoryRepo.findAll();
    }

    @Override
    public Optional<CategoryEntity> getById(Long id) {
        if(id == 0L)
            return Optional.empty();

        return this.categoryRepo.findById(id);
    }

    @Override
    public Optional<CategoryEntity> getByCode(String code) {
        if(code == null || code.isEmpty())
            return Optional.empty();

        return this.categoryRepo.findByCode(code);
    }

    @Override
    public Optional<CategoryEntity> save(CategoryModel request) {
        CategoryEntity entity = new CategoryEntity();
        BeanUtils.copyProperties(request, entity);
        try {
            this.categoryRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryEntity> update(CategoryModel request, Long id) {
        if(id == 0L)
            return Optional.empty();

        CategoryEntity entity = this.categoryRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        BeanUtils.copyProperties(request, entity);
        try {
            this.categoryRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryEntity> delete(Long id) {
        if(id == 0L)
            return Optional.empty();

        CategoryEntity entity = this.categoryRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        try {
            this.categoryRepo.delete(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
