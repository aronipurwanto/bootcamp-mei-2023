package com.ahmadroni.pos.service.impl;

import com.ahmadroni.pos.entity.ProductEntity;
import com.ahmadroni.pos.model.request.ProductRequest;
import com.ahmadroni.pos.model.response.ProductResponse;
import com.ahmadroni.pos.repository.CategoryRepo;
import com.ahmadroni.pos.repository.ProductRepo;
import com.ahmadroni.pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    @Override
    public List<ProductResponse> getAll() {
        List<ProductEntity> entities = this.productRepo.findAll();
        if(entities.isEmpty()){
            return Collections.emptyList();
        }

        List<ProductResponse> responses = entities.stream().map(entity -> {
            return new ProductResponse(entity);
        }).collect(Collectors.toList());

        return responses;
    }

    @Override
    public Optional<ProductResponse> getById(Long id) {
        if(id == 0L)
            return Optional.empty();
        var result = this.productRepo.findById(id).orElse(null);
        if(result == null){
            Optional.empty();
        }

        ProductResponse response = new ProductResponse(result);
        return Optional.of(response);
    }

    @Override
    public Optional<ProductResponse> getByCode(String code) {
        if(code == null || code.isEmpty())
            return Optional.empty();
        var result = this.productRepo.findByCode(code).orElse(null);
        if(result == null){
            return Optional.empty();
        }
        ProductResponse response = new ProductResponse(result);
        return Optional.of(response);
    }

    @Override
    public Optional<ProductEntity> save(ProductRequest request) {
        // check category id
        if(request.getCategoryId() == 0L){
            return Optional.empty();
        }

        // check category di database
        var category = this.categoryRepo.findById(request.getCategoryId()).orElse(null);
        if(category == null){
            return Optional.empty();
        }

        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(request, entity);

        // set data yang tidak ada di model
        entity.setDiscontinued(false);
        entity.setUnitOnOrder(0.0);
        try {
            this.productRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductEntity> update(ProductRequest request, Long id) {
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
