package com.caloteiros.spring.controllers;

import com.caloteiros.spring.models.user.RequestNewUserDTO;
import com.caloteiros.spring.models.user.User;
import com.caloteiros.spring.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/new")
    public ModelAndView newUserForm() {
        ModelAndView mv = new ModelAndView("users/new-user");
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid  RequestNewUserDTO request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("users/new-user");
            return mv;
        } else {
            User user = request.toUser();
            this.userService.register(user);

            return new ModelAndView("redirect:/auth/login");
        }
    }

}
