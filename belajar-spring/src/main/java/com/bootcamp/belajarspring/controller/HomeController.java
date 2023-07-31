package com.bootcamp.belajarspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String ping(){
        return "ping";
    }

    @GetMapping("test")
    public String testApi(){
        return "Test-Api";
    }
}
