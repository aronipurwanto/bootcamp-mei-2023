package com.ahmadroni.pos.repository;

import com.ahmadroni.pos.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepo extends JpaRepository<SupplierEntity, Long> {
    Optional<SupplierEntity> findByCode(String code);
}
