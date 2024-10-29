package com.caloteiros.spring.controllers;

import com.caloteiros.spring.models.user.User;
import com.caloteiros.spring.services.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/login")
    public ModelAndView loginForm() {
        ModelAndView mv = new ModelAndView("login-form");
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute User user, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        if(authService.userExists(user)) {
           session.setAttribute("authenticatedUser", user);
           mv.setViewName("menu");
            return mv;
        }
        mv.setViewName("login-form");
        return mv;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userLogged");
        return "redirect:loginForm";
    }


}