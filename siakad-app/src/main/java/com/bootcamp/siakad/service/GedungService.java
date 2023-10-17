package com.bootcamp.siakad.service;

import com.bootcamp.siakad.model.GedungModel;

import java.util.List;
import java.util.Optional;

public interface GedungService {
    List<GedungModel> getAll();
    Optional<GedungModel> getById(Long id);
    Optional<GedungModel> save(GedungModel request);
    Optional<GedungModel> update(GedungModel request, Long id);
    Optional<GedungModel> delete(Long id);
}
