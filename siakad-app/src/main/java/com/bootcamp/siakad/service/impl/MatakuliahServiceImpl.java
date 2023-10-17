package com.bootcamp.siakad.service.impl;

import com.bootcamp.siakad.entity.MatakuliahEntity;
import com.bootcamp.siakad.model.MatakuliahModel;
import com.bootcamp.siakad.repository.MatakuliahRepository;
import com.bootcamp.siakad.service.MatakuliahService;
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
public class MatakuliahServiceImpl implements MatakuliahService {
    private final MatakuliahRepository repo;
    @Override
    public List<MatakuliahModel> getAll() {
        List<MatakuliahEntity> result  = this.repo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(MatakuliahModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MatakuliahModel> getById(Long id) {
        MatakuliahEntity result = this.repo.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }

        return Optional.of(new MatakuliahModel(result));
    }

    @Override
    public Optional<MatakuliahModel> save(MatakuliahModel request) {
        if(request == null) {
            return Optional.empty();
        }

        MatakuliahEntity entity = new MatakuliahEntity(request);
        try{
            this.repo.save(entity);
            return Optional.of(new MatakuliahModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<MatakuliahModel> update(MatakuliahModel request, Long id) {
        MatakuliahEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try{
            this.repo.save(entity);
            return Optional.of(new MatakuliahModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<MatakuliahModel> delete(Long id) {
        MatakuliahEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        try{
            this.repo.delete(entity);
            return Optional.of(new MatakuliahModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
