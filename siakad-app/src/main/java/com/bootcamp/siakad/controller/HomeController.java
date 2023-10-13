package com.bootcamp.siakad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    private String index(){
        return "pages/home/index";
    }

    @GetMapping("/home")
    private String home(){
        return "pages/home/index";
    }
}
