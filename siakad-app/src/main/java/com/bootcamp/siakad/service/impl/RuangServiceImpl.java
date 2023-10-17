package com.bootcamp.siakad.service.impl;

import com.bootcamp.siakad.entity.RuangEntity;
import com.bootcamp.siakad.model.RuangModel;
import com.bootcamp.siakad.repository.RuangRepository;
import com.bootcamp.siakad.service.RuangService;
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
public class RuangServiceImpl implements RuangService {
    private final RuangRepository repo;
    @Override
    public List<RuangModel> getAll() {
        List<RuangEntity> result  = this.repo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(RuangModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RuangModel> getById(Long id) {
        RuangEntity result = this.repo.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }

        return Optional.of(new RuangModel(result));
    }

    @Override
    public Optional<RuangModel> save(RuangModel request) {
        if(request == null) {
            return Optional.empty();
        }

        RuangEntity entity = new RuangEntity(request);
        try{
            this.repo.save(entity);
            return Optional.of(new RuangModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<RuangModel> update(RuangModel request, Long id) {
        RuangEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try{
            this.repo.save(entity);
            return Optional.of(new RuangModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<RuangModel> delete(Long id) {
        RuangEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        try{
            this.repo.delete(entity);
            return Optional.of(new RuangModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
