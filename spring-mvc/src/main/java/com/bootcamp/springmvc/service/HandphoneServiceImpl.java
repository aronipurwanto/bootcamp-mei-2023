package com.bootcamp.springmvc.service;

import com.bootcamp.springmvc.entity.HandphoneEntity;
import com.bootcamp.springmvc.model.HandphoneDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandphoneServiceImpl implements HandphoneService{
    @Override
    public List<HandphoneEntity> getAll() {
        return null;
    }

    @Override
    public HandphoneEntity getById(Integer id) {
        return null;
    }

    @Override
    public HandphoneEntity save(HandphoneDto request) {
        return null;
    }

    @Override
    public HandphoneEntity update(Integer id, HandphoneDto request) {
        return null;
    }

    @Override
    public HandphoneEntity delete(Integer id) {
        return null;
    }
}
