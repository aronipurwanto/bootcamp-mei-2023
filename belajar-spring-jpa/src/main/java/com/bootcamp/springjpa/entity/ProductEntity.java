package com.bootcamp.springjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class ProductEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_name", length = 150)
    private String name;

    @Column(name = "product_desc")
    private String description;

    @Column(name = "product_price")
    private int price;

    @Column(name = "product_qty")
    private int quantity;
}
