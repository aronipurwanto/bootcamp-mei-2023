package com.bootcamp.siakad.service.impl;

import com.bootcamp.siakad.entity.FakultasEntity;
import com.bootcamp.siakad.model.FakultasModel;
import com.bootcamp.siakad.repository.FakultasRepository;
import com.bootcamp.siakad.service.FakultasService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
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
public class FakultasServiceImpl implements FakultasService {
    private final FakultasRepository repo;
    @Override
    public List<FakultasModel> getAll() {
        List<FakultasEntity> result  = this.repo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(FakultasModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FakultasModel> getById(Long id) {
        FakultasEntity result = this.repo.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }

        return Optional.of(new FakultasModel(result));
    }

    @Override
    public Optional<FakultasModel> save(FakultasModel request) {
        if(request == null) {
            return Optional.empty();
        }

        FakultasEntity entity = new FakultasEntity(request);
        try{
            this.repo.save(entity);
            return Optional.of(new FakultasModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<FakultasModel> update(FakultasModel request, Long id) {
        FakultasEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try{
            this.repo.save(entity);
            return Optional.of(new FakultasModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<FakultasModel> delete(Long id) {
        FakultasEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        try{
            this.repo.delete(entity);
            return Optional.of(new FakultasModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
