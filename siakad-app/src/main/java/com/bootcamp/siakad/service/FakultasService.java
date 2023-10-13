package com.bootcamp.siakad.service;

import com.bootcamp.siakad.model.FakultasModel;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Optional;

public interface FakultasService {
    List<FakultasModel> getAll();
    Optional<FakultasModel> getById(Long id);
    Optional<FakultasModel> save(FakultasModel request);
    Optional<FakultasModel> update(FakultasModel request, Long id);
    Optional<FakultasModel> delete(Long id);
}
