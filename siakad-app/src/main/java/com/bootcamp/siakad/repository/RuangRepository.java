package com.bootcamp.siakad.repository;

import com.bootcamp.siakad.entity.RuangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuangRepository extends JpaRepository<RuangEntity, Long> {
}
