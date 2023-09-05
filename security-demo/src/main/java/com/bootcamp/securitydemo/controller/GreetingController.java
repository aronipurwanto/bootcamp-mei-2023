package com.bootcamp.securitydemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greeting")
public class GreetingController {

    @GetMapping("/say-hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok()
                .body("Hello, welcome from Security API");
    }

    @GetMapping("/say-good-bye")
    public ResponseEntity<String> sayGoodBy(){
        return ResponseEntity.ok()
                .body("Hello, Good by from Security API");
    }
}
