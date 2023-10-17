package com.bootcamp.siakad.repository;

import com.bootcamp.siakad.entity.MatakuliahEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatakuliahRepository extends JpaRepository<MatakuliahEntity, Long> {
}
