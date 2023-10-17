package com.bootcamp.siakad.service.impl;

import com.bootcamp.siakad.entity.LookupEntity;
import com.bootcamp.siakad.model.LookupModel;
import com.bootcamp.siakad.repository.LookupRepository;
import com.bootcamp.siakad.service.LookupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class LookupServiceImpl implements LookupService {
    private final LookupRepository repo;
    @Override
    public List<LookupModel> getAll() {
        List<LookupEntity> result  = this.repo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(LookupModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LookupModel> getById(Long id) {
        LookupEntity result = this.repo.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }

        return Optional.of(new LookupModel(result));
    }

    @Override
    public Optional<LookupModel> save(LookupModel request) {
        if(request == null) {
            return Optional.empty();
        }

        LookupEntity entity = new LookupEntity(request);
        try{
            this.repo.save(entity);
            return Optional.of(new LookupModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<LookupModel> update(LookupModel request, Long id) {
        LookupEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try{
            this.repo.save(entity);
            return Optional.of(new LookupModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<LookupModel> delete(Long id) {
        LookupEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        try{
            this.repo.delete(entity);
            return Optional.of(new LookupModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
