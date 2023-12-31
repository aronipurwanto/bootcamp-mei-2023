package com.bootcamp.springjpa.controller;

import com.bootcamp.springjpa.entity.ProductEntity;
import com.bootcamp.springjpa.model.ProductDto;
import com.bootcamp.springjpa.model.Response;
import com.bootcamp.springjpa.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        ProductEntity result = productService.getById(id);
        return ResponseEntity.ok()
                .body(new Response(200,"Success", result));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ProductDto request){
        ProductEntity result = productService.save(request);
        String message = "Success";
        if(result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PostMapping("/save-form")
    public ResponseEntity<Object> saveForm(@ModelAttribute ProductDto request){
        ProductEntity result = productService.save(request);
        String message = "Success";
        if(result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        ProductEntity result = productService.delete(id);
        return ResponseEntity.ok()
                .body(new Response(200,"Success", result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id,
                                         @RequestBody ProductDto request){
        ProductEntity result = productService.update(id, request);
        String message = "Success";
        if(result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }

    @PatchMapping("/{id}/update-form")
    public ResponseEntity<Object> updateForm(@PathVariable Integer id,
                                         @ModelAttribute ProductDto request){
        ProductEntity result = productService.update(id, request);
        String message = "Success";
        if(result == null){
            message = "Failed";
        }
        return ResponseEntity.ok()
                .body(new Response(200, message, result));
    }
}
