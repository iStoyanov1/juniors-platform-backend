package com.example.demo.services.interfaces;

import com.example.demo.data.models.service.RoleServiceModel;

import java.util.Set;

public interface RoleService {

    void saveRole();

    Set<RoleServiceModel> findAllRoles();

    RoleServiceModel findByAuthority(String authority);
}
