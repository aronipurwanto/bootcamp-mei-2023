package com.ahmadroni.pos.service.impl;

import com.ahmadroni.pos.entity.SupplierEntity;
import com.ahmadroni.pos.model.SupplierModel;
import com.ahmadroni.pos.repository.SupplierRepo;
import com.ahmadroni.pos.service.SupplierService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepo SupplierRepo;

    @Override
    public List<SupplierEntity> getAll() {
        return this.SupplierRepo.findAll();
    }

    @Override
    public Optional<SupplierEntity> getById(Long id) {
        if(id == 0L)
            return Optional.empty();

        return this.SupplierRepo.findById(id);
    }

    @Override
    public Optional<SupplierEntity> save(SupplierModel request) {
        SupplierEntity entity = new SupplierEntity();
        BeanUtils.copyProperties(request, entity);
        try {
            this.SupplierRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
            log.error("Save Supplier failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierEntity> update(SupplierModel request, Long id) {
        if(id == 0L)
            return Optional.empty();

        SupplierEntity entity = this.SupplierRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        BeanUtils.copyProperties(request, entity);
        try {
            this.SupplierRepo.save(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<SupplierEntity> delete(Long id) {
        if(id == 0L)
            return Optional.empty();

        SupplierEntity entity = this.SupplierRepo.findById(id).orElse(null);
        if(entity == null)
            return Optional.empty();

        try {
            this.SupplierRepo.delete(entity);
            return Optional.of(entity);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
