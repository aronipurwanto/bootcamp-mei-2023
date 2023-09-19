package com.ahmadroni.pos.repository;

import com.ahmadroni.pos.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByCode(String code);
}
