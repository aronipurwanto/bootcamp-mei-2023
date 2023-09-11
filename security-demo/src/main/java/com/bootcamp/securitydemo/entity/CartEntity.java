package com.bootcamp.securitydemo.entity;

import com.bootcamp.securitydemo.dto.CartDto;
import com.bootcamp.securitydemo.dto.CartItemDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tbl_cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "invoice_no", length = 20)
    private String invoiceNo;

    @Column(name = "total")
    private Double total;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Column(nullable = true)
    @JsonManagedReference
    private List<CartItemEntity> cartItems = new ArrayList<>();

    public void addCartItem(CartItemEntity itemEntity){
        this.cartItems.add(itemEntity);
        itemEntity.setCart(this);
    }

    public void removeCartItem(CartItemEntity itemEntity){
        this.cartItems.remove(itemEntity);
        itemEntity.setCart(null);
    }

    public CartEntity(CartDto cartDto) {
        this.id = UUID.randomUUID().toString();
        this.invoiceNo = cartDto.getInvoiceNo();
        this.createdAt = LocalDateTime.now();

        Double vTotal = 0.0;
        for(CartItemDto itemDto: cartDto.getCartItems()){
            CartItemEntity itemEntity = new CartItemEntity(itemDto, this.id);
            this.addCartItem(itemEntity);
            vTotal+= itemEntity.getSubTotal();
        }
        this.total = vTotal;
    }
}
