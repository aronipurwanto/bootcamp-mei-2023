package com.bootcamp.siakad.service;

import com.bootcamp.siakad.model.RoleModel;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<RoleModel> getAll();
    Optional<RoleModel> getById(Long id);
    Optional<RoleModel> save(RoleModel request);
    Optional<RoleModel> update(RoleModel request, Long id);
    Optional<RoleModel> delete(Long id);
}
