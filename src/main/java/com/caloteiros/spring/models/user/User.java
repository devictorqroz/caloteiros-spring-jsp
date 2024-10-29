package com.caloteiros.spring.models.user;

import jakarta.validation.constraints.Size;

public class User {

    private Long id;
    @Size(min = 3, max = 20, message = "Usuário deve conter entre 3 a 20 caracteres.")
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}