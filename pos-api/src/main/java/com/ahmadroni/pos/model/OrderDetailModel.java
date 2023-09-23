package com.ahmadroni.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {
    private Long productId;
    private Double price;
    private Double quantity;
}
