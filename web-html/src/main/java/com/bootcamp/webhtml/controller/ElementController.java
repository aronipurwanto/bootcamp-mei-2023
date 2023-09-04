package com.bootcamp.webhtml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/element")
public class ElementController {
    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("pages/element/index");
    }

    @GetMapping("/attribute")
    public ModelAndView attributes(){
        return new ModelAndView("pages/element/attribute");
    }
}
