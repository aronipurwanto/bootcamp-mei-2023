package com.bootcamp.securitydemo.service;

import com.bootcamp.securitydemo.dto.CartDto;
import com.bootcamp.securitydemo.dto.CartItemDto;
import com.bootcamp.securitydemo.entity.CartEntity;
import com.bootcamp.securitydemo.entity.CartItemEntity;
import com.bootcamp.securitydemo.repository.CardRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CardRepo cardRepo;
    @Override
    public List<CartEntity> getAll() {
        return this.cardRepo.findAll();
    }

    @Override
    public Optional<CartEntity> getById(String id) {
        if(id.isEmpty())
            return Optional.empty();

        return this.cardRepo.findById(id);
    }

    @Override
    public Optional<CartEntity> save(CartDto request) {
        if(request == null)
            return Optional.empty();

        CartEntity cart = new CartEntity();
        cart.setId(UUID.randomUUID().toString());
        cart.setInvoiceNo(request.getInvoiceNo());

        // total
        double total = 0.0;
        for(CartItemDto itemDto: request.getCartItems()){
            CartItemEntity itemEntity = new CartItemEntity();
            itemEntity.setId(UUID.randomUUID().toString());
            itemEntity.setCartId(cart.getId());
            itemEntity.setProductId(itemDto.getProductId());
            itemEntity.setQty(itemDto.getQty());
            itemEntity.setPrice(itemDto.getPrice());
            itemEntity.setSubTotal(itemDto.getQty() * itemDto.getPrice());

            // add to list
            cart.addCartItem(itemEntity);

            total = total + itemEntity.getSubTotal();
        }
        // set total
        cart.setTotal(total);

        try{
            this.cardRepo.save(cart);
            log.info("Save cart success");
            return Optional.of(cart);
        }catch (Exception e){
            log.error("Save cart failed, Error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
