package com.bootcamp.springapi.controller;

import com.bootcamp.springapi.model.Orang;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping("ping")
    public String ping(){
        return "pong";
    }

    @GetMapping("orang")
    public Orang getOrang(){
        Orang data = new Orang();
        return data;
    }

    @GetMapping("orang/{id}")
    public Orang getOrang(@PathVariable int id){
        Orang data = new Orang();
        data.setId(id);
        return data;
    }

    @GetMapping("orang/{id}/{nama}")
    public Orang getOrang(@PathVariable int id,
                          @PathVariable String nama){
        Orang data = new Orang();
        data.setId(id);
        data.setNama(nama);
        return data;
    }

    @GetMapping("orang/{id}/{nama}/{umur}")
    public Orang getOrang(@PathVariable int id,
                          @PathVariable String nama,
                          @PathVariable int umur){
        Orang data = new Orang();
        data.setId(id);
        data.setNama(nama);
        data.setUmur(umur);

        return data;
    }

    @GetMapping("orang/{id}/{nama}/{umur}/{alamat}")
    public Orang getOrang(@PathVariable int id,
                          @PathVariable String nama,
                          @PathVariable int umur,
                          @PathVariable String alamat){
        Orang data = new Orang();
        data.setId(id);
        data.setNama(nama);
        data.setUmur(umur);
        data.setAlamat(alamat);

        return data;
    }
}
