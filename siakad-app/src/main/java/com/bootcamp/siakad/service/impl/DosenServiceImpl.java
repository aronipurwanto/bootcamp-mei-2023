package com.bootcamp.siakad.service.impl;

import com.bootcamp.siakad.entity.DosenEntity;
import com.bootcamp.siakad.model.DosenModel;
import com.bootcamp.siakad.repository.DosenRepository;
import com.bootcamp.siakad.service.DosenService;
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
public class DosenServiceImpl implements DosenService {
    private final DosenRepository repo;
    @Override
    public List<DosenModel> getAll() {
        List<DosenEntity> result  = this.repo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(DosenModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DosenModel> getById(Long id) {
        DosenEntity result = this.repo.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }

        return Optional.of(new DosenModel(result));
    }

    @Override
    public Optional<DosenModel> save(DosenModel request) {
        if(request == null) {
            return Optional.empty();
        }

        DosenEntity entity = new DosenEntity(request);
        try{
            this.repo.save(entity);
            return Optional.of(new DosenModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<DosenModel> update(DosenModel request, Long id) {
        DosenEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try{
            this.repo.save(entity);
            return Optional.of(new DosenModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<DosenModel> delete(Long id) {
        DosenEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        try{
            this.repo.delete(entity);
            return Optional.of(new DosenModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
