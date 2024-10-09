package com.caloteiros.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

}
