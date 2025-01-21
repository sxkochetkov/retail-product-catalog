package com.example.product_catalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * We need this forwarder as frontend and backend packaged as one application
 */
@Controller
public class ForwardController {

    @GetMapping(value = "/**/{path:[^\\.]*}")
    public String proxy() {
        return "forward:/";
    }
}
