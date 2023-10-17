package com.bootcamp.siakad.service;

import com.bootcamp.siakad.model.MahasiswaModel;

import java.util.List;
import java.util.Optional;

public interface MahasiswaService {
    List<MahasiswaModel> getAll();
    Optional<MahasiswaModel> getById(Long id);
    Optional<MahasiswaModel> save(MahasiswaModel request);
    Optional<MahasiswaModel> update(MahasiswaModel request, Long id);
    Optional<MahasiswaModel> delete(Long id);
}
