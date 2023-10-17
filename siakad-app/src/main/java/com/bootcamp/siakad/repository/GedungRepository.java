package com.bootcamp.siakad.repository;

import com.bootcamp.siakad.entity.GedungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GedungRepository extends JpaRepository<GedungEntity, Long> {
}
