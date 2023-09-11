package com.bootcamp.securitydemo.controller;

import com.bootcamp.securitydemo.dto.CartDto;
import com.bootcamp.securitydemo.dto.Response;
import com.bootcamp.securitydemo.entity.CartEntity;
import com.bootcamp.securitydemo.entity.ProductEntity;
import com.bootcamp.securitydemo.repository.ProductRepo;
import com.bootcamp.securitydemo.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final ProductRepo productRepo;

    @GetMapping("")
    public ResponseEntity<Response> getAll(){
        List<CartEntity> result = this.cartService.getAll();
        return ResponseEntity.ok().body(
                new Response(200,"SUCCESS", result)
        );
    }

    @GetMapping(value = "/product", produces = {"application/json"})
    public ResponseEntity<Response> getProduct(){
        List<ProductEntity> result = this.productRepo.findAll();
        return ResponseEntity.ok().body(
                new Response(200,"SUCCESS", result)
        );
    }



    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable("id") String id){
        return ResponseEntity
                .ok()
                .body(
                        new Response(200,"SUCCESS", this.cartService.getById(id))
                );
    }

    @PostMapping("")
    public ResponseEntity<Response> save(@RequestBody CartDto request){
        Optional<CartEntity> result = this.cartService.save(request);

        if(result.isPresent()){
            return ResponseEntity
                    .ok()
                    .body(
                            new Response(200,"SUCCESS", result)
                    );
        }else {
            return ResponseEntity
                    .status(500)
                    .body(
                            new Response(500,"FAILED", null)
                    );
        }

    }

    @PostMapping("/simple")
    public ResponseEntity<Response> simpleSave(@RequestBody CartDto request){
        Optional<CartEntity> result = this.cartService.simpleSave(request);

        if(result.isPresent()){
            return ResponseEntity
                    .ok()
                    .body(
                            new Response(200,"SUCCESS", result)
                    );
        }else {
            return ResponseEntity
                    .status(500)
                    .body(
                            new Response(500,"FAILED", null)
                    );
        }

    }
}
