package com.bootcamp.securitydemo.repository;

import com.bootcamp.securitydemo.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo extends JpaRepository<CartItemEntity, String> {
}
