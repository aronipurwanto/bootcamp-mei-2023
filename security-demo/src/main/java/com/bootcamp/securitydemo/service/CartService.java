package com.bootcamp.securitydemo.service;

import com.bootcamp.securitydemo.dto.CartDto;
import com.bootcamp.securitydemo.entity.CartEntity;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<CartEntity> getAll();
    Optional<CartEntity> getById(String id);
    Optional<CartEntity> save(CartDto request);
}
