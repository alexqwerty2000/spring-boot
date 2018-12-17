package com.danit.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Value("${spring.datasource.url}")
    private String datasource;

    @GetMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.put("datasource", datasource.split(";")[0]);
        return "index";
    }
}


