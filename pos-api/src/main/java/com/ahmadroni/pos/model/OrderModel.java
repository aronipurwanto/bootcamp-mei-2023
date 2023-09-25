package com.ahmadroni.pos.model;

import com.ahmadroni.pos.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    public OrderModel(OrderEntity entity) {
        this.invoiceNo = entity.getInvoiceNo();
        this.orderDate = entity.getOrderDate();
        this.grandTotal = entity.getGrandTotal();
        // memanggil contructor OrderShipModel(entity)
        this.ship = new OrderShipModel(entity);

        if(entity.getCustomer() != null) {
            // memanggil constructor CustomerModel(entity)
            this.customer = new CustomerModel(entity.getCustomer());
        }

        if(!entity.getOrderDetails().isEmpty()) {
            this.orderDetail = entity.getOrderDetails()
                    .stream()
                    .map(OrderDetailModel::new)
                    .collect(Collectors.toList());
        }
    }
}