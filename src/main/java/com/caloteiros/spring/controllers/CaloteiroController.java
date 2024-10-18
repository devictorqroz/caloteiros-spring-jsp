package com.caloteiros.spring.controllers;

import com.caloteiros.spring.dto.RequestNewCaloteiro;
import com.caloteiros.spring.models.Caloteiro;
import com.caloteiros.spring.services.CaloteiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/caloteiros")
public class CaloteiroController {

    @Autowired
    CaloteiroService caloteiroService;

    @GetMapping
    public ModelAndView findAll() {
        List<Caloteiro> caloteiros = caloteiroService.findAll();
        ModelAndView model = new ModelAndView("caloteiros/list-caloteiros");
        model.addObject("caloteiros", caloteiros);
        return model;
    }

    @GetMapping("/new")
    public ModelAndView newCaloteiroForm(RequestNewCaloteiro request) {
        ModelAndView model = new ModelAndView("caloteiros/new-caloteiro");
        return model;
    }

    @PostMapping
    public ModelAndView createCaloteiroForm(@Valid RequestNewCaloteiro request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView model = new ModelAndView("caloteiros/new-caloteiro");
            return model;
        } else {
            Caloteiro caloteiro = request.toCaloteiro();
            this.caloteiroService.create(caloteiro);

            return new ModelAndView("redirect:/caloteiros/caloteiro-created");
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCaloteiroById(@PathVariable Long id) {
        caloteiroService.deleteById(id);
        return "redirect:/caloteiros/caloteiro-deleted";
    }

    @GetMapping("/{id}/edit")
    public String updateCaloteiroForm(@PathVariable Long id, Model model) {
        Optional<Caloteiro> optionalCaloteiro = caloteiroService.findById(id);

        if (optionalCaloteiro.isPresent()) {
            model.addAttribute("caloteiro", optionalCaloteiro.get());
        } else {
            return "redirect:/caloteiros";
        }
        return "/caloteiros/update-caloteiro";
    }

    @PutMapping("/{id}")
    public String updateCaloteiro(@PathVariable Long id, @ModelAttribute Caloteiro updateCaloteiro) {
        caloteiroService.update(id, updateCaloteiro);
        return "redirect:/caloteiros/caloteiro-updated";
    }

    @GetMapping("/caloteiro-deleted")
    public ModelAndView caloteiroDeleted() {
        return new ModelAndView("caloteiros/caloteiro-deleted");
    }

    @GetMapping("/caloteiro-created")
    public ModelAndView caloteiroCreated() {
        return new ModelAndView("caloteiros/caloteiro-created");
    }

    @GetMapping("/caloteiro-updated")
    public ModelAndView caloteiroUpdated() {
        return new ModelAndView("caloteiros/caloteiro-updated");
    }

}
