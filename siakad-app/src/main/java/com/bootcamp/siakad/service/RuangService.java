package com.bootcamp.siakad.service;

import com.bootcamp.siakad.model.RuangModel;

import java.util.List;
import java.util.Optional;

public interface RuangService {
    List<RuangModel> getAll();
    Optional<RuangModel> getById(Long id);
    Optional<RuangModel> save(RuangModel request);
    Optional<RuangModel> update(RuangModel request, Long id);
    Optional<RuangModel> delete(Long id);
}
