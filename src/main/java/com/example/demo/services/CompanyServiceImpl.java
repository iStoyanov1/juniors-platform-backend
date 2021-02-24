package com.example.demo.services;

import com.example.demo.data.entites.Company;
import com.example.demo.data.models.service.CompanyServiceModel;
import com.example.demo.repositories.CompanyAdministrativeInfoRepository;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.repositories.CompanySignInRepository;
import com.example.demo.services.interfaces.CompanyAdministrativeInfoService;
import com.example.demo.services.interfaces.CompanyService;
import com.example.demo.services.interfaces.CompanySignInService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;
    private final CompanyAdministrativeInfoRepository companyAdministrativeInfoRepository;
    private final CompanySignInRepository companySignInRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public CompanyServiceImpl(ModelMapper modelMapper, CompanyRepository companyRepository, CompanyAdministrativeInfoRepository companyAdministrativeInfoRepository, CompanySignInRepository companySignInRepository, BCryptPasswordEncoder bCryptPasswordEncoder, CompanySignInService companySignInService, CompanyAdministrativeInfoService companyAdministrativeInfoService) {
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
        this.companyAdministrativeInfoRepository = companyAdministrativeInfoRepository;
        this.companySignInRepository = companySignInRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    @Override
    public CompanyServiceModel registerCompany(CompanyServiceModel companyServiceModel) {
        Company company = this.modelMapper.map(companyServiceModel, Company.class);
        return this.modelMapper.map(this.companyRepository.saveAndFlush(company), CompanyServiceModel.class);

    }
}
