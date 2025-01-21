package com.example.product_catalog.controllers;

import com.example.product_catalog.services.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigurationController {
    @Autowired
    private ConfigurationService configurationService;

    // sample of request: `/config?action=prepopulate`
    @GetMapping("")
    public String getAllProducts(@RequestParam(value = "action", required = false) String action) {
        // Error earl on
        if(action == null)
            return "No Action specified";

        if (action.equals("prepopulate"))
            return configurationService.prepopulate();
        else
            return "Unrecognized action";
    }
}
