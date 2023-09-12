package com.bootcamp.securitydemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private String customerName;
    private String invoiceNo;
    private List<CartItemDto> cartItems;
}
