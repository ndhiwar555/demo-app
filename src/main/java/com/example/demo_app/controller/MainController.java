package com.example.demo_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api")
@RestController
public class MainController {

    @GetMapping(value = "/")
    public String getMsg() {
        return "Hello World";
    }
}
