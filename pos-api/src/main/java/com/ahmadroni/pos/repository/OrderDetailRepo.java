package com.ahmadroni.pos.repository;

import com.ahmadroni.pos.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetailEntity, Long> {
    List<OrderDetailEntity> findByOrderId(Long orderId);
}
