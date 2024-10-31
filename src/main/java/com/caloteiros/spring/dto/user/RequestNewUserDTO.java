package com.caloteiros.spring.dto.user;

import com.caloteiros.spring.models.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestNewUserDTO (
    @NotBlank
    @Size(min = 3, max = 30, message = "Username deve conter entre 3 a 30 caracteres.")
    String username,

    @NotBlank
    @Size(min = 6, max = 70, message = "Password deve conter entre 6 a 70 caracteres.")
    String password
) {
    public User toUser(String salt) {
        return new User(this.username, this.password, salt);
    }
}