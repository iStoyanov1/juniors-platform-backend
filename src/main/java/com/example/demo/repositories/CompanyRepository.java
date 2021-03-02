package com.example.demo.repositories;

import com.example.demo.data.entites.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {


}
