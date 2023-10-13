package com.bootcamp.siakad.repository;

import com.bootcamp.siakad.entity.JurusanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurusanRepository extends JpaRepository<JurusanEntity, Long> {
}
