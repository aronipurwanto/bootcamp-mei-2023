package com.bootcamp.siakad.service;

import com.bootcamp.siakad.model.DosenModel;

import java.util.List;
import java.util.Optional;

public interface DosenService {
    List<DosenModel> getAll();
    Optional<DosenModel> getById(Long id);
    Optional<DosenModel> save(DosenModel request);
    Optional<DosenModel> update(DosenModel request, Long id);
    Optional<DosenModel> delete(Long id);
}
