package com.ahmadroni.pos.service.impl;

import com.ahmadroni.pos.entity.ProductEntity;
import com.ahmadroni.pos.model.ProductModel;
import com.ahmadroni.pos.repository.ProductRepo;
import com.ahmadroni.pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public List<ProductEntity> getAll() {
        return this.productRepo.findAll();
    }

    @Override
    public Optional<ProductEntity> getById(Long id) {
        if(id == 0L)
            return Optional.empty();

        return this.productRepo.findById(id);
    }

    @Override
    public Optional<ProductEntity> getByCode(String code) {
        if(code == null || code.isEmpty())
            return Optional.empty();

        return this.productRepo.findByCode(code);
    }

    @Override
    public Optional<ProductEntity> save(ProductModel request) {
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(request, entity);
        try {
            this.productRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductEntity> update(ProductModel request, Long id) {
        if(id == 0L)
            return Optional.empty();

        ProductEntity entity = this.productRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        BeanUtils.copyProperties(request, entity);
        try {
            this.productRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductEntity> delete(Long id) {
        if(id == 0L)
            return Optional.empty();

        ProductEntity entity = this.productRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        try {
            this.productRepo.delete(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
