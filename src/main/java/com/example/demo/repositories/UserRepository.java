package com.example.demo.repositories;

import com.example.demo.data.entites.File;
import com.example.demo.data.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findUserByAuth_Id(String id);


}
