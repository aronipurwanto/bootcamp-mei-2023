package com.bootcamp.springmvc.controller;

import com.bootcamp.springmvc.entity.ProductEntity;
import com.bootcamp.springmvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("product/index");

        String judul = "List Product";
        view.addObject("dataJudul", judul);

        // get data dari service, service => repo, repo => database
        List<ProductEntity> dataProduct = service.getAll();
        // kirim data ke view
        view.addObject("listProduct", dataProduct);
        // menghitung jumlah data
        int jmlData = dataProduct.size();
        // kirim data ke view
        view.addObject("jmlData", jmlData);
        return view;
    }
}
