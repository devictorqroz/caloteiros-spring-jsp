package com.caloteiros.spring.services;

import com.caloteiros.spring.models.user.User;
import com.caloteiros.spring.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository repository;

    public boolean userExists(User user) {
        if(repository.userExists(user)) {
           return true;
        }
        return false;
    }


}
