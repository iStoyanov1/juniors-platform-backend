package com.example.demo.data.models.service;

import com.example.demo.data.models.service.base.BaseServiceModel;

import java.util.Set;

public class AuthServiceModel extends BaseServiceModel {

    private String username;
    private String password;
    private Set<RoleServiceModel> authorities;

    public AuthServiceModel() {
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

    public Set<RoleServiceModel> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<RoleServiceModel> authorities) {
        this.authorities = authorities;
    }
}
