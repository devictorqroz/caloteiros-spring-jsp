package com.caloteiros.spring.controllers;

import com.caloteiros.spring.models.user.User;
import com.caloteiros.spring.services.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService service;


    @GetMapping("/loginForm")
    public String loginForm() {
        return "login-form";
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String login(@ModelAttribute User user, HttpSession session) {
        if(service.userExists(user)) {
           session.setAttribute("authenticatedUser", user);
           return "menu";
        }
        return "redirect:loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userLogged");
        return "redirect:loginForm";
    }


}