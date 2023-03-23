package com.llit.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/hoome/page")
    public String index() {

        return "Hoome page";
    }
}
