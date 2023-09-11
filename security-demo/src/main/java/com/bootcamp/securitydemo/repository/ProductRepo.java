package com.bootcamp.securitydemo.repository;

import com.bootcamp.securitydemo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, String> {
}
