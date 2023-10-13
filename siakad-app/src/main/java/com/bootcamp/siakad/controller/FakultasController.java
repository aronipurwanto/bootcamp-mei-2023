package com.bootcamp.siakad.controller;

import com.bootcamp.siakad.model.FakultasModel;
import com.bootcamp.siakad.service.FakultasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/fakultas")
@RequiredArgsConstructor
public class FakultasController {
    private final FakultasService service;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/fakultas/index");
        // get data from service
        List<FakultasModel> data = service.getAll();
        // send data to view
        view.addObject("dataList", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView addFakultas(){
        ModelAndView view = new ModelAndView("pages/fakultas/add");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView saveFakultas(@ModelAttribute FakultasModel request){
        // call save from service
        service.save(request);
        // redirect to index
        return new ModelAndView("redirect:/fakultas");
    }

    // edit method get
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("pages/fakultas/edit");
        FakultasModel data = service.getById(id).orElse(null);
        if(data == null){
            return new ModelAndView("redirect:/fakultas");
        }

        // data send to view
        view.addObject("data", data);
        return view;
    }

    // update data
    @PostMapping("/update")
    public ModelAndView updateFakultas(@ModelAttribute FakultasModel request){
        // call save from service
        service.update(request, request.getId());
        // redirect to index
        return new ModelAndView("redirect:/fakultas");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("pages/fakultas/detail");
        // get data from service
        FakultasModel data = service.getById(id).orElse(null);
        if(data == null){
            return new ModelAndView("redirect:/fakultas");
        }

        // send data to view
        view.addObject("data",data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/fakultas";
    }
}
