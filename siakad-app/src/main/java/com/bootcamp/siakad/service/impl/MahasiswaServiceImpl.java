package com.bootcamp.siakad.service.impl;

import com.bootcamp.siakad.entity.MahasiswaEntity;
import com.bootcamp.siakad.model.MahasiswaModel;
import com.bootcamp.siakad.repository.MahasiswaRepository;
import com.bootcamp.siakad.service.MahasiswaService;
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
public class MahasiswaServiceImpl implements MahasiswaService {
    private final MahasiswaRepository repo;
    @Override
    public List<MahasiswaModel> getAll() {
        List<MahasiswaEntity> result  = this.repo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(MahasiswaModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MahasiswaModel> getById(Long id) {
        MahasiswaEntity result = this.repo.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }

        return Optional.of(new MahasiswaModel(result));
    }

    @Override
    public Optional<MahasiswaModel> save(MahasiswaModel request) {
        if(request == null) {
            return Optional.empty();
        }

        MahasiswaEntity entity = new MahasiswaEntity(request);
        try{
            this.repo.save(entity);
            return Optional.of(new MahasiswaModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<MahasiswaModel> update(MahasiswaModel request, Long id) {
        MahasiswaEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try{
            this.repo.save(entity);
            return Optional.of(new MahasiswaModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<MahasiswaModel> delete(Long id) {
        MahasiswaEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        try{
            this.repo.delete(entity);
            return Optional.of(new MahasiswaModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
