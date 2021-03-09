package com.example.demo.services.interfaces;

import com.example.demo.data.models.service.AuthServiceModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    AuthServiceModel setCredentials(AuthServiceModel authServiceModel);

    AuthServiceModel findAuthById(String id);

    boolean checkUsernameExist(String username);

    AuthServiceModel findByUsername(String username);
}
