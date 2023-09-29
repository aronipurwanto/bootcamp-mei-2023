package com.ahmadroni.pos.service.impl;

import com.ahmadroni.pos.entity.CustomerEntity;
import com.ahmadroni.pos.model.CustomerModel;
import com.ahmadroni.pos.model.response.CustomerResponse;
import com.ahmadroni.pos.repository.CustomerRepo;
import com.ahmadroni.pos.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    @Override
    public List<CustomerResponse> getAll() {
        List<CustomerEntity> result = this.customerRepo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream()
                .map(CustomerResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerEntity> getById(Long id) {
        if(id == 0L)
            return Optional.empty();

        return this.customerRepo.findById(id);
    }

    @Override
    public Optional<CustomerEntity> save(CustomerModel request) {
        CustomerEntity entity = new CustomerEntity();
        BeanUtils.copyProperties(request, entity);
        try {
            this.customerRepo.save(entity);
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

        CustomerEntity entity = this.customerRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        BeanUtils.copyProperties(request, entity);
        try {
            this.customerRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerEntity> delete(Long id) {
        if(id == 0L)
            return Optional.empty();

        CustomerEntity entity = this.customerRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        try {
            this.customerRepo.delete(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
