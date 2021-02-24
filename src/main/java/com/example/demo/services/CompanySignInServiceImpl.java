package com.example.demo.services;

import com.example.demo.data.entites.CompanySignIn;
import com.example.demo.data.models.service.CompanyServiceModel;
import com.example.demo.data.models.service.CompanySignInServiceModel;
import com.example.demo.repositories.CompanySignInRepository;
import com.example.demo.services.interfaces.CompanySignInService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanySignInServiceImpl implements CompanySignInService {

    private final ModelMapper modelMapper;
    private final CompanySignInRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CompanySignInServiceImpl(ModelMapper modelMapper, CompanySignInRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.modelMapper = modelMapper;
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void saveCompanySignInInformation(CompanySignInServiceModel companySignInServiceModel) {
        CompanySignIn companySignIn = this.modelMapper.map(companySignInServiceModel, CompanySignIn.class);

        companySignIn.setCompanySignInPassword(this.bCryptPasswordEncoder.encode(companySignIn.getCompanySignInPassword()));

        this.modelMapper.map(this.repository.saveAndFlush(companySignIn), CompanySignInServiceModel.class);
    }

    @Override
    public boolean findByEmail(String email) {
        CompanySignIn findByEmail = this.repository.findByCompanySignInEmail(email);

        if (findByEmail == null){
            return false;
        }
        return true;
    }
}
