package com.caloteiros.spring.services.user;

import com.caloteiros.spring.exceptions.UserAlreadyExistsException;
import com.caloteiros.spring.models.user.User;
import com.caloteiros.spring.repositories.UserRepository;
import com.caloteiros.spring.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void register(User user) {
        Optional<User> existingUser = userRepository.findUserByUsername(user.getUsername());

        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("Nome de usuário já está sendo utilizado");
        }

        user.setPassword(PasswordUtils.passwordEncoder(user.getPassword(), user.getSalt()));
        userRepository.save(user);
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
