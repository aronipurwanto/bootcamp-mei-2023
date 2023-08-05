package com.bootcamp.springjpa.controller;

import com.bootcamp.springjpa.entity.ProductEntity;
import com.bootcamp.springjpa.model.Response;
import com.bootcamp.springjpa.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<ProductEntity> result = productService.getAll();
        return ResponseEntity.ok()
                .body(new Response(200,"Success", result));
    }
}
