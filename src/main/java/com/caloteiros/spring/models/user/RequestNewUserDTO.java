package com.caloteiros.spring.models.user;

import jakarta.validation.constraints.NotBlank;

public class RequestNewUserDTO {

    @NotBlank
    private String username;
    @NotBlank
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser() {
        User user = new User(this.username, this.password);
        return user;
    }

    @Override
    public String toString() {
        return "RequestNewUserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
