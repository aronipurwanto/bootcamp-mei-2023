package com.bootcamp.springjpa.service;

import com.bootcamp.springjpa.entity.ProductEntity;
import com.bootcamp.springjpa.model.ProductDto;
import com.bootcamp.springjpa.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepo.findAll();
    }

    @Override
    public ProductEntity getById(Integer id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public ProductEntity save(ProductDto request) {
        ProductEntity result = new ProductEntity();
        result.setId(request.getId());
        result.setName(request.getName());
        result.setDescription(request.getDescription());
        result.setPrice(request.getPrice());
        result.setQuantity(request.getQuantity());

        try{
            productRepo.save(result);
            log.info("Save product to database successfully");
            return result;
        }catch (Exception e) {
            log.error("Save product to database failed, error: {}", e.getMessage());
            return null;
        }
    }
}
