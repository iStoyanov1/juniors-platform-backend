package com.example.demo.repositories;

import com.example.demo.data.entites.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Auth, String> {


    Auth findByUsername(String username);

    Optional<Auth> findById(String id);



}
