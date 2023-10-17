package com.bootcamp.siakad.service;

import com.bootcamp.siakad.model.LookupModel;

import java.util.List;
import java.util.Optional;

public interface LookupService {
    List<LookupModel> getAll();
    Optional<LookupModel> getById(Long id);
    Optional<LookupModel> save(LookupModel request);
    Optional<LookupModel> update(LookupModel request, Long id);
    Optional<LookupModel> delete(Long id);
}
