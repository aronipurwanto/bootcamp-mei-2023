package com.bootcamp.siakad.service.impl;

import com.bootcamp.siakad.entity.JurusanEntity;
import com.bootcamp.siakad.model.JurusanModel;
import com.bootcamp.siakad.repository.JurusanRepository;
import com.bootcamp.siakad.service.JurusanService;
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
public class JurusanServiceImpl implements JurusanService {
    private final JurusanRepository repo;
    @Override
    public List<JurusanModel> getAll() {
        List<JurusanEntity> result  = this.repo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(JurusanModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JurusanModel> getById(Long id) {
        JurusanEntity result = this.repo.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }

        return Optional.of(new JurusanModel(result));
    }

    @Override
    public Optional<JurusanModel> save(JurusanModel request) {
        if(request == null) {
            return Optional.empty();
        }

        JurusanEntity entity = new JurusanEntity(request);
        try{
            this.repo.save(entity);
            return Optional.of(new JurusanModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<JurusanModel> update(JurusanModel request, Long id) {
        JurusanEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try{
            this.repo.save(entity);
            return Optional.of(new JurusanModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<JurusanModel> delete(Long id) {
        JurusanEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        try{
            this.repo.delete(entity);
            return Optional.of(new JurusanModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
