package com.bootcamp.securitydemo.controller;

import com.bootcamp.securitydemo.dto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greeting")
public class GreetingController {

    @GetMapping("/say-hello")
    public ResponseEntity<Response> sayHello(){
        return ResponseEntity.ok()
                .body(new Response(200,"SUCCESS","Hello, welcome from Security API"));
    }

    @GetMapping("/say-good-bye")
    public ResponseEntity<Response> sayGoodBy(){
        return ResponseEntity.ok()
                .body(new Response(200,"SUCCESS","Hello, Good by from Security API"));
    }
}
