package com.bootcamp.springjpa.controller;

import com.bootcamp.springjpa.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping("ping")
    public ResponseEntity<Response> ping(){
        Response result = new Response(200,"Success","Ping");
        return ResponseEntity.ok()
                .body(result);
    }
}
