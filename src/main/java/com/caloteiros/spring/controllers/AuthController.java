package com.caloteiros.spring.controllers;

import com.caloteiros.spring.dto.auth.LoginRequestDTO;
import com.caloteiros.spring.dto.user.RequestNewUserDTO;
import com.caloteiros.spring.exceptions.UserNotFoundException;
import com.caloteiros.spring.models.user.User;
import com.caloteiros.spring.services.auth.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller()
public class AuthController {

    @Autowired
    AuthService authService;

    private static final String LOGIN_REDIRECT = "redirect:/login";

    @GetMapping("/login")
    public ModelAndView loginForm() {
        return new ModelAndView("login-form");
    }

    @PostMapping("/login")
    public ModelAndView login(
            @Valid @ModelAttribute LoginRequestDTO loginRequestDTO,
            BindingResult bindingResult,
            HttpSession session) {

        ModelAndView mv = new ModelAndView();

        if (bindingResult.hasErrors()) {
            mv.setViewName("login-form");
            mv.addObject("error", "Nome de usuário ou senha inválidos");
            return mv;
        }

        try {
            User user = authService.authenticate(loginRequestDTO.username(), loginRequestDTO.password())
                    .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));
            session.setAttribute("currentUser", user);
            mv.setViewName("menu");
            return mv;
        } catch (UserNotFoundException e) {
            mv.setViewName("login-form");
            mv.addObject("error", "Nome de usuário ou senha inválidos");
            return mv;
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("currentUser");
        return LOGIN_REDIRECT;
    }
}