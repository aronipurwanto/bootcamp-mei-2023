package com.bootcamp.securitydemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_cart_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "card_id", length = 36, nullable = false)
    private String cartId;

    @Column(name = "product_id", length = 36, nullable = false)
    private String productId;

    @Column(name = "qty")
    private Double qty;

    @Column(name = "price")
    private Double price;

    @Column(name = "sub_total")
    private Double subTotal;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @JsonBackReference
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", insertable = false, updatable = false)
    @JsonBackReference
    private CartEntity cart;
}
