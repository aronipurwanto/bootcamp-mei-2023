package com.bootcamp.siakad.service.impl;

import com.bootcamp.siakad.entity.RoleEntity;
import com.bootcamp.siakad.model.RoleModel;
import com.bootcamp.siakad.repository.RoleRepository;
import com.bootcamp.siakad.service.RoleService;
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
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repo;
    @Override
    public List<RoleModel> getAll() {
        List<RoleEntity> result  = this.repo.findAll();
        if(result.isEmpty()){
            return Collections.emptyList();
        }

        return result.stream().map(RoleModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RoleModel> getById(Long id) {
        RoleEntity result = this.repo.findById(id).orElse(null);
        if(result == null) {
            return Optional.empty();
        }

        return Optional.of(new RoleModel(result));
    }

    @Override
    public Optional<RoleModel> save(RoleModel request) {
        if(request == null) {
            return Optional.empty();
        }

        RoleEntity entity = new RoleEntity(request);
        try{
            this.repo.save(entity);
            return Optional.of(new RoleModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<RoleModel> update(RoleModel request, Long id) {
        RoleEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        BeanUtils.copyProperties(request, entity);
        entity.setId(id);
        try{
            this.repo.save(entity);
            return Optional.of(new RoleModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<RoleModel> delete(Long id) {
        RoleEntity entity = this.repo.findById(id).orElse(null);
        if(entity == null) {
            return Optional.empty();
        }

        try{
            this.repo.delete(entity);
            return Optional.of(new RoleModel(entity));
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
