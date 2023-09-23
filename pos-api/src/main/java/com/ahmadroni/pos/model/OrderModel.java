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
    private CustomerModel customer;
    private Date orderDate;
    private Date shippedDate;
    private OrderShipModel ship;
    private List<OrderDetailModel> orderDetail;
}
