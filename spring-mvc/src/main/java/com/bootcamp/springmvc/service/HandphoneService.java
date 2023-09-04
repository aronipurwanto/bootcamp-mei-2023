package com.bootcamp.springmvc.service;

import com.bootcamp.springmvc.entity.HandphoneEntity;
import com.bootcamp.springmvc.model.HandphoneDto;

import java.util.List;

public interface HandphoneService {
    List<HandphoneEntity> getAll();
    HandphoneEntity getById(Integer id);
    HandphoneEntity save(HandphoneDto request);
    HandphoneEntity update(Integer id, HandphoneDto request);
    HandphoneEntity delete(Integer id);
}
