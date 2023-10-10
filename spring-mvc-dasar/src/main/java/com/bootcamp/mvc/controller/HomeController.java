package com.bootcamp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "pages/home/index";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "pages/home/dashboard";
    }

    @GetMapping("/welcome")
    public ModelAndView welcome(){
        ModelAndView view = new ModelAndView("pages/home/welcome");
        String name = "Anu";
        view.addObject("name", name);

        String hoby = "Nonton Anime, sama Begadang, Lupa tidur";
        view.addObject("hoby", hoby);

        int umur = 17;
        view.addObject("age", umur);
        return view;
    }
}
