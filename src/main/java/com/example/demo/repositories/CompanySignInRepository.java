package com.example.demo.repositories;

import com.example.demo.data.entites.Company;
import com.example.demo.data.entites.CompanySignIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySignInRepository extends JpaRepository<CompanySignIn, String> {

   CompanySignIn findByCompanySignInEmail(String email);

}
