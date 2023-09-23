package com.ahmadroni.pos.service.impl;

import com.ahmadroni.pos.entity.CustomerEntity;
import com.ahmadroni.pos.model.CustomerModel;
import com.ahmadroni.pos.repository.CustomerRepo;
import com.ahmadroni.pos.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo CustomerRepo;

    @Override
    public List<CustomerEntity> getAll() {
        return this.CustomerRepo.findAll();
    }

    @Override
    public Optional<CustomerEntity> getById(Long id) {
        if(id == 0L)
            return Optional.empty();

        return this.CustomerRepo.findById(id);
    }

    @Override
    public Optional<CustomerEntity> getByCode(String code) {
        if(code == null || code.isEmpty())
            return Optional.empty();

        return this.CustomerRepo.findByCode(code);
    }

    @Override
    public Optional<CustomerEntity> save(CustomerModel request) {
        CustomerEntity entity = new CustomerEntity();
        BeanUtils.copyProperties(request, entity);
        try {
            this.CustomerRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
            log.error("Save customer failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerEntity> update(CustomerModel request, Long id) {
        if(id == 0L)
            return Optional.empty();

        CustomerEntity entity = this.CustomerRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        BeanUtils.copyProperties(request, entity);
        try {
            this.CustomerRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerEntity> delete(Long id) {
        if(id == 0L)
            return Optional.empty();

        CustomerEntity entity = this.CustomerRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        try {
            this.CustomerRepo.delete(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
