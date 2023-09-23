package com.ahmadroni.pos.service;

import com.ahmadroni.pos.entity.CustomerEntity;
import com.ahmadroni.pos.model.CustomerModel;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerEntity> getAll();
    Optional<CustomerEntity> getById(Long id);
    Optional<CustomerEntity> save(CustomerModel request);
    Optional<CustomerEntity> update(CustomerModel request, Long id);
    Optional<CustomerEntity> delete(Long id);
}
