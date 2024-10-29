package com.caloteiros.spring.services;

import com.caloteiros.spring.models.user.User;
import com.caloteiros.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void register(User user) {
        userRepository.save(user);
    }

}
