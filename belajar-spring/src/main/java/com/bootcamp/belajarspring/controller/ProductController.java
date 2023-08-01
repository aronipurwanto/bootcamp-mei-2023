package com.bootcamp.belajarspring.controller;

import com.bootcamp.belajarspring.model.Product;
import com.bootcamp.belajarspring.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/direct")
    public Product getDirect(){
        return new Product();
    }

    @GetMapping("/direct2")
    public Product getDirect2(){
        return new Product(1,
                "Kopi",
                "Kopi Robusta asli Lampung nikmat sekali",
                75000,
                1);
    }

    @PostMapping
    public ResponseEntity<Object> postData(@RequestBody Product request){
        return ResponseEntity
                .ok()
                .body("Data berhasil diterima");
    }

    @PostMapping("/with-response")
    public ResponseEntity<Object> postDataWithResponse(@RequestBody Product request){
        Response result = new Response(200,"SUCCESS",request);
        return ResponseEntity
                .ok()
                .body(result);
    }
}
