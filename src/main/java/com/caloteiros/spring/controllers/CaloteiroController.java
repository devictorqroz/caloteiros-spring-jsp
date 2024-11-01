package com.caloteiros.spring.controllers;

import com.caloteiros.spring.dto.caloteiro.RequestNewCaloteiroDTO;
import com.caloteiros.spring.models.caloteiro.Caloteiro;
import com.caloteiros.spring.models.user.User;
import com.caloteiros.spring.services.caloteiro.CaloteiroService;
import jakarta.servlet.http.HttpSession;
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
    public ModelAndView findAll(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return new ModelAndView("redirect:/login");
        }

        List<Caloteiro> caloteiros = caloteiroService.findAllByUserId(currentUser.getId());
        ModelAndView model = new ModelAndView("caloteiros/list-caloteiros");
        model.addObject("caloteiros", caloteiros);
        return model;
    }

    @GetMapping("/new")
    public ModelAndView newCaloteiroForm(RequestNewCaloteiroDTO request) {
        ModelAndView model = new ModelAndView("caloteiros/new-caloteiro");
        return model;
    }

    @PostMapping
    public ModelAndView createCaloteiro(
            @Valid @ModelAttribute RequestNewCaloteiroDTO request,
            BindingResult bindingResult,
            HttpSession session) {

        if (bindingResult.hasErrors()) {
            ModelAndView model = new ModelAndView("caloteiros/new-caloteiro");
            return model;
        }

        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return new ModelAndView("redirect:/login");
        }

        Caloteiro caloteiro = request.toCaloteiro();
        caloteiro.setUserId(currentUser.getId());
        this.caloteiroService.create(caloteiro);

        return new ModelAndView("redirect:/caloteiros/caloteiro-created");
    }

    @DeleteMapping("/{id}")
    public String deleteCaloteiroById(@PathVariable Long id, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }

        caloteiroService.deleteById(id, currentUser.getId());
        return "redirect:/caloteiros/caloteiro-deleted";
    }

    @GetMapping("/{id}/edit")
    public String updateCaloteiroForm(@PathVariable Long id, Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }

        Optional<Caloteiro> caloteiroToUpdate = caloteiroService.findById(id, currentUser.getId());

        if (caloteiroToUpdate.isPresent()) {
            model.addAttribute("caloteiro", caloteiroToUpdate.get());
            return "/caloteiros/update-caloteiro";
        } else {
            return "redirect:/caloteiros";
        }
    }

    @PutMapping("/{id}")
    public String updateCaloteiro(@PathVariable Long id, @ModelAttribute Caloteiro updateCaloteiro, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        updateCaloteiro.setUserId(currentUser.getId());
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
