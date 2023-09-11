package com.bootcamp.securitydemo.repository;

import com.bootcamp.securitydemo.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository<CartEntity, String> {
}
