package com.caloteiros.spring.services.auth;

import com.caloteiros.spring.exceptions.InvalidCredentialsException;
import com.caloteiros.spring.exceptions.UserNotFoundException;
import com.caloteiros.spring.models.user.User;
import com.caloteiros.spring.services.user.UserService;
import com.caloteiros.spring.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    UserService userService;

    public Optional<User> authenticate(String username, String password) {
        User user = userService.findUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        String storedSalt = user.getSalt();

        String encodedPassword = PasswordUtils.passwordEncoder(password, storedSalt);

        if (encodedPassword.equals(user.getPassword())) {
            return Optional.of(user);
        } else {
            throw new InvalidCredentialsException("Usuário ou senha inválida");
        }
    }
}
