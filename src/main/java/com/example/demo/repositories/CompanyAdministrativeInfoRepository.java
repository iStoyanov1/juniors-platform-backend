package com.example.demo.repositories;

import com.example.demo.data.entites.CompanyAdministrativeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyAdministrativeInfoRepository extends JpaRepository<CompanyAdministrativeInfo, String> {

    CompanyAdministrativeInfo findByEmail(String email);
}
