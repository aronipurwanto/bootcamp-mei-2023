package com.bootcamp.springjpa.service;

import com.bootcamp.springjpa.entity.ProductEntity;
import com.bootcamp.springjpa.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepo.findAll();
    }
}
