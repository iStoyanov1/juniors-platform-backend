package com.example.demo.data.models.dtos;

public class AuthLoginDto {

    private String username;
    private String password;

    public AuthLoginDto() {
    }

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
}
