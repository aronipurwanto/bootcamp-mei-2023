package com.ahmadroni.pos.repository;

import com.ahmadroni.pos.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByCode(String code);
}
