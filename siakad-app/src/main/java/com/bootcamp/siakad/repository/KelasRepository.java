package com.bootcamp.siakad.repository;

import com.bootcamp.siakad.entity.KelasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelasRepository extends JpaRepository<KelasEntity, Long> {
}
