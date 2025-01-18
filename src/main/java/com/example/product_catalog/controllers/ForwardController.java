package com.example.product_catalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForwardController {

    @GetMapping(value = "/**/{path:[^\\.]*}")
    public String proxy() {
        return "forward:/";
    }
}
