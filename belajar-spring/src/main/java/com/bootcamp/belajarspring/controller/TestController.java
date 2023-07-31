package com.bootcamp.belajarspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/ping")
    public String getPing(){
        return "test-ping";
    }

    @GetMapping("/hitung")
    public Integer getHing(){
        return 100;
    }

    @GetMapping("/pecahan")
    public Double getPecahan(){
        return 50.50;
    }

    @GetMapping("/bool")
    public Boolean getBool(){
        return false;
    }
}
