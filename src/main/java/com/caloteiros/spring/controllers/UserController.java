package com.caloteiros.spring.controllers;

import com.caloteiros.spring.dto.user.RequestNewUserDTO;
import com.caloteiros.spring.exceptions.UserAlreadyExistsException;
import com.caloteiros.spring.models.user.User;
import com.caloteiros.spring.services.user.UserService;
import com.caloteiros.spring.utils.PasswordUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return new ModelAndView("users/new-user");
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid @ModelAttribute RequestNewUserDTO requestNewUser, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("users/new-user");
        if (bindingResult.hasErrors()) {
            return mv;
        }
        try {
            String salt = PasswordUtils.generateSalt();
            User user = requestNewUser.toUser(salt);
            this.userService.register(user);
            return new ModelAndView("login-form");
        } catch (UserAlreadyExistsException e) {
            mv.addObject("errorMessage", e.getMessage());
            return mv;
        }
    }
}
