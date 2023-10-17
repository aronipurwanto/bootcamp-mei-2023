package com.bootcamp.siakad.repository;

import com.bootcamp.siakad.entity.LookupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LookupRepository extends JpaRepository<LookupEntity, Long> {
}
