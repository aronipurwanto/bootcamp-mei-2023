package com.bootcamp.siakad.service;

import com.bootcamp.siakad.model.JurusanModel;

import java.util.List;
import java.util.Optional;

public interface JurusanService {
    List<JurusanModel> getAll();
    Optional<JurusanModel> getById(Long id);
    Optional<JurusanModel> save(JurusanModel request);
    Optional<JurusanModel> update(JurusanModel request, Long id);
    Optional<JurusanModel> delete(Long id);
}
