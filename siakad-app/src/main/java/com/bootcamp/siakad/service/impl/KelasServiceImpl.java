package com.bootcamp.siakad.service.impl;

import com.bootcamp.siakad.entity.KelasEntity;
import com.bootcamp.siakad.model.KelasModel;
import com.bootcamp.siakad.repository.KelasRepository;
import com.bootcamp.siakad.service.KelasService;
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
public class KelasServiceImpl implements KelasService {
    private final KelasRepository repo;
    @Override
    public List<KelasModel> getAll() {
        List<KelasEntity> result  = this.repo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(KelasModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<KelasModel> getById(Long id) {
        KelasEntity result = this.repo.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }

        return Optional.of(new KelasModel(result));
    }

    @Override
    public Optional<KelasModel> save(KelasModel request) {
        if(request == null) {
            return Optional.empty();
        }

        KelasEntity entity = new KelasEntity(request);
        try{
            this.repo.save(entity);
            return Optional.of(new KelasModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<KelasModel> update(KelasModel request, Long id) {
        KelasEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try{
            this.repo.save(entity);
            return Optional.of(new KelasModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<KelasModel> delete(Long id) {
        KelasEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        try{
            this.repo.delete(entity);
            return Optional.of(new KelasModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
