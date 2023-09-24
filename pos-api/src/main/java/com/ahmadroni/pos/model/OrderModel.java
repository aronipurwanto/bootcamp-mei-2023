package com.ahmadroni.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    private String invoiceNo;
    private Date orderDate;
    private Double grandTotal;
    private OrderShipModel ship;
    private CustomerModel customer;
    private List<OrderDetailModel> orderDetail;
}