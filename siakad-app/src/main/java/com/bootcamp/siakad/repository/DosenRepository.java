package com.bootcamp.siakad.repository;

import com.bootcamp.siakad.entity.DosenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosenRepository extends JpaRepository<DosenEntity, Long> {
}
