package com.ahmadroni.pos.controller;

import com.ahmadroni.pos.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping("test")
    public ResponseEntity<ResponseModel> getTest(){
        return ResponseEntity.ok()
                .body(new ResponseModel(200,"SUCCESS","Welcome to POS API"));
    }
}
