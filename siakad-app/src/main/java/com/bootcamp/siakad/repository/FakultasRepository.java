package com.bootcamp.siakad.repository;

import com.bootcamp.siakad.entity.FakultasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakultasRepository extends JpaRepository<FakultasEntity, Long> {
}
