package com.ahmadroni.pos.repository;

import com.ahmadroni.pos.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByEmail(String email);
    Optional<CustomerEntity> findByPhone(String phone);
}
