package com.bootcamp.siakad.service;

import com.bootcamp.siakad.model.MatakuliahModel;

import java.util.List;
import java.util.Optional;

public interface MatakuliahService {
    List<MatakuliahModel> getAll();
    Optional<MatakuliahModel> getById(Long id);
    Optional<MatakuliahModel> save(MatakuliahModel request);
    Optional<MatakuliahModel> update(MatakuliahModel request, Long id);
    Optional<MatakuliahModel> delete(Long id);
}
