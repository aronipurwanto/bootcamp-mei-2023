package com.bootcamp.mvc.controller;

import com.bootcamp.mvc.model.FakultasModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fakultas")
public class FakultasController {
    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/fakultas/index");
        Long vId = 1L;
        view.addObject("id",vId);

        String vCode = "FE";
        view.addObject("code",vCode);

        String vName = "Fakultas Ekonomi";
        view.addObject("name", vName);

        String vDescription = "Fakultas Ekonomi Description";
        view.addObject("desc", vDescription);
        return view;
    }

    @GetMapping("/detail")
    public ModelAndView detail(){
        ModelAndView view = new ModelAndView("pages/fakultas/detail");
        FakultasModel fakultas = new FakultasModel(1L,"FE", "Fakultas Ekonomi","Fakultas Ekonomi Desc");
        view.addObject("data", fakultas);
        return view;
    }
}
