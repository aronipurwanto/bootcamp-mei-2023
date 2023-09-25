package com.ahmadroni.pos.service;

import com.ahmadroni.pos.entity.OrderEntity;
import com.ahmadroni.pos.model.OrderModel;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderModel> getAll();
    Optional<OrderModel> getById(Long id);
    List<OrderModel> getByCustomerId(Long customerId);
    Optional<OrderModel> getByInvoiceNo(String invoiceNo);
    Optional<OrderEntity> save(OrderModel request);
    Optional<OrderEntity> update(OrderModel request, Long id);
    Optional<OrderEntity> delete(Long id);
}
