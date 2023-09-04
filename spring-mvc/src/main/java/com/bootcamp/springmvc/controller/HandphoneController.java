package com.bootcamp.springmvc.controller;

import com.bootcamp.springmvc.entity.HandphoneEntity;
import com.bootcamp.springmvc.service.HandphoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/hp")
public class HandphoneController {
    private HandphoneService service;

    public HandphoneController(HandphoneService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        List<HandphoneEntity> result = service.getAll();
        ModelAndView view = new ModelAndView("handphone/index");
        view.addObject("data", result);
        return view;
    }
}
