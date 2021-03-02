package com.example.demo.services;

import com.example.demo.data.entites.Auth;
import com.example.demo.data.entites.Company;
import com.example.demo.data.models.service.CompanyServiceModel;
import com.example.demo.repositories.AuthRepository;
import com.example.demo.repositories.CompanyAdministrativeInfoRepository;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.services.interfaces.CompanyAdministrativeInfoService;
import com.example.demo.services.interfaces.CompanyService;
import com.example.demo.services.interfaces.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;
    private final CompanyAdministrativeInfoRepository companyAdministrativeInfoRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;
    private final AuthRepository authRepository;


    public CompanyServiceImpl(ModelMapper modelMapper, CompanyRepository companyRepository, CompanyAdministrativeInfoRepository companyAdministrativeInfoRepository
            , BCryptPasswordEncoder bCryptPasswordEncoder, CompanyAdministrativeInfoService companyAdministrativeInfoService, RoleService roleService, AuthRepository authRepository) {
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
        this.companyAdministrativeInfoRepository = companyAdministrativeInfoRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
        this.authRepository = authRepository;
    }

    @Override
    public CompanyServiceModel registerCompany(CompanyServiceModel companyServiceModel) {

        companyServiceModel.getAuthServiceModel().setAuthorities(new LinkedHashSet<>());
        companyServiceModel.getAuthServiceModel().getAuthorities().add(this.roleService.findByAuthority("COMPANY"));

        Company company = this.modelMapper.map(companyServiceModel, Company.class);

        Auth auth = this.modelMapper.map(companyServiceModel.getAuthServiceModel(), Auth.class);

        this.authRepository.saveAndFlush(auth);

        return this.modelMapper.map(this.companyRepository.saveAndFlush(company), CompanyServiceModel.class);

    }
}
