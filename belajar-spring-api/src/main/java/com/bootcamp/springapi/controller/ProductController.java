package com.bootcamp.springapi.controller;

import com.bootcamp.springapi.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @GetMapping
    public Product get(){
        return new Product();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable int id){
        Product data = new Product();
        data.setId(id);
        return data;
    }

    @GetMapping("/{id}/{nama}")
    public Product get(@PathVariable int id,
                       @PathVariable String nama){
        Product data = new Product();
        data.setId(id);
        data.setNama(nama);

        return data;
    }

    @GetMapping("/{id}/{nama}/{harga}")
    public Product get(@PathVariable int id,
                       @PathVariable String nama,
                       @PathVariable int harga){
        Product data = new Product();
        data.setId(id);
        data.setNama(nama);
        data.setHarga(harga);

        return data;
    }
}
