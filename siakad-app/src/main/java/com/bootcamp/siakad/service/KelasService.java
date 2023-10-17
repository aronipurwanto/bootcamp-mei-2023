package com.bootcamp.siakad.service;

import com.bootcamp.siakad.model.KelasModel;

import java.util.List;
import java.util.Optional;

public interface KelasService {
    List<KelasModel> getAll();
    Optional<KelasModel> getById(Long id);
    Optional<KelasModel> save(KelasModel request);
    Optional<KelasModel> update(KelasModel request, Long id);
    Optional<KelasModel> delete(Long id);
}
