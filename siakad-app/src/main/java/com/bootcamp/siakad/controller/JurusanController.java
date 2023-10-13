package com.bootcamp.siakad.controller;

import com.bootcamp.siakad.model.FakultasModel;
import com.bootcamp.siakad.model.JurusanModel;
import com.bootcamp.siakad.service.FakultasService;
import com.bootcamp.siakad.service.JurusanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jurusan")
@RequiredArgsConstructor
public class JurusanController {
    private final JurusanService service;
    private final FakultasService fakultasService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/jurusan/index");
        // get data from service
        List<JurusanModel> data = service.getAll();
        // send data to view
        view.addObject("dataList", data);
        return view;
    }

    @GetMapping("/add")
    public ModelAndView addJurusan(){
        ModelAndView view = new ModelAndView("pages/jurusan/add");
        // get data fakultas
        List<FakultasModel> dataFakultas = this.fakultasService.getAll();
        // data kirim ke view
        view.addObject("dataFakultas", dataFakultas);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView saveJurusan(@ModelAttribute JurusanModel request){
        // call save from service
        service.save(request);
        // redirect to index
        return new ModelAndView("redirect:/jurusan");
    }

    // edit method get
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("pages/jurusan/edit");
        JurusanModel data = service.getById(id).orElse(null);
        if(data == null){
            return new ModelAndView("redirect:/jurusan");
        }

        // get data fakultas
        List<FakultasModel> dataFakultas = this.fakultasService.getAll();
        // data kirim ke view
        view.addObject("dataFakultas", dataFakultas);

        // data send to view
        view.addObject("data", data);
        return view;
    }

    // update data
    @PostMapping("/update")
    public ModelAndView updateJurusan(@ModelAttribute JurusanModel request){
        // call save from service
        service.update(request, request.getId());
        // redirect to index
        return new ModelAndView("redirect:/jurusan");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") long id){
        ModelAndView view = new ModelAndView("pages/jurusan/detail");
        // get data from service
        JurusanModel data = service.getById(id).orElse(null);
        if(data == null){
            return new ModelAndView("redirect:/jurusan");
        }

        // send data to view
        view.addObject("data",data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);
        return "redirect:/jurusan";
    }
}
