package com.caloteiros.spring.controllers;

import com.caloteiros.spring.dto.RequestNewCaloteiro;
import com.caloteiros.spring.models.Caloteiro;
import com.caloteiros.spring.services.CaloteiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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


    @GetMapping("/caloteiros")
    public ModelAndView findAll() {
        List<Caloteiro> caloteiros = caloteiroService.findAll();
        ModelAndView model = new ModelAndView("list-caloteiros");
        model.addObject("caloteiros", caloteiros);
        return model;
    }

    @GetMapping("caloteiros/new")
    public ModelAndView newCaloteiroForm() {
        ModelAndView model = new ModelAndView("caloteiros/new-caloteiro");
        return model;
    }

    @PostMapping("/caloteiros")
    public ModelAndView create(@Valid RequestNewCaloteiro request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView model = new ModelAndView("caloteiros/new-caloteiro");
            return model;
        } else {
            Caloteiro caloteiro = request.toCaloteiro();
            this.caloteiroService.create(caloteiro);

            return new ModelAndView("redirect:/caloteiros");
        }
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
