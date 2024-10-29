package com.caloteiros.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @GetMapping(path = {"/", "/menu"})
    public ModelAndView menu() {
        ModelAndView model = new ModelAndView("menu");
        return model;
    }

}
