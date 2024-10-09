package com.caloteiros.spring.controllers;

import com.caloteiros.spring.models.Caloteiro;
import com.caloteiros.spring.services.CaloteiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class CaloteiroController {

    @Autowired
    CaloteiroService caloteiroService;

    @GetMapping("/{id}")
    public Caloteiro findById(@PathVariable Long id) {
        var caloteiro = caloteiroService.findById(id);
        if (caloteiro.isEmpty()) {
            throw new RuntimeException();
        }
        return caloteiro.get();
    }

    @GetMapping("/list-caloteiros")
    public ModelAndView findAll(ModelAndView model) {
        List<Caloteiro> caloteiros = caloteiroService.findAll();
        model.setViewName("list-caloteiros");
        model.addObject("caloteiros", caloteiros);
        return model;
    }

    @PostMapping
    public void create(@RequestBody Caloteiro caloteiro) {
        caloteiroService.create(caloteiro);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        caloteiroService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody Caloteiro caloteiro) {
        caloteiroService.update(caloteiro);
    }

}
