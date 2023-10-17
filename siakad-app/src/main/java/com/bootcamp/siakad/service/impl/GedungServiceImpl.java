package com.bootcamp.siakad.service.impl;

import com.bootcamp.siakad.entity.GedungEntity;
import com.bootcamp.siakad.model.GedungModel;
import com.bootcamp.siakad.repository.GedungRepository;
import com.bootcamp.siakad.service.GedungService;
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
public class GedungServiceImpl implements GedungService {
    private final GedungRepository repo;
    @Override
    public List<GedungModel> getAll() {
        List<GedungEntity> result  = this.repo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(GedungModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GedungModel> getById(Long id) {
        GedungEntity result = this.repo.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }

        return Optional.of(new GedungModel(result));
    }

    @Override
    public Optional<GedungModel> save(GedungModel request) {
        if(request == null) {
            return Optional.empty();
        }

        GedungEntity entity = new GedungEntity(request);
        try{
            this.repo.save(entity);
            return Optional.of(new GedungModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<GedungModel> update(GedungModel request, Long id) {
        GedungEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try{
            this.repo.save(entity);
            return Optional.of(new GedungModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<GedungModel> delete(Long id) {
        GedungEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        try{
            this.repo.delete(entity);
            return Optional.of(new GedungModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
