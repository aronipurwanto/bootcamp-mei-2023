package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public Product get(){
        Product data1 = new Product();
        return data1;
    }

    @GetMapping("/data")
    public Product getData(){
        Product data1 = new Product(1,
                "Laptop",
                "Ini Laptop Description",
                100000000,
                10);

        return data1;
    }
}
