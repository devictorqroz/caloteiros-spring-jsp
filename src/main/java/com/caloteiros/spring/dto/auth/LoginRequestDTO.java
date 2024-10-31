package com.caloteiros.spring.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDTO (
    @NotBlank
    @Size(min = 3, max = 20, message = "Username deve conter entre 3 a 20 caracteres.")
    String username,

    @NotBlank
    @Size(min = 6, max = 70, message = "Password deve conter entre 6 a 20 caracteres.")
    String password
) {}
