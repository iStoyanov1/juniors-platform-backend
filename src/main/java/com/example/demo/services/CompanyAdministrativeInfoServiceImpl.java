package com.example.demo.services;

import com.example.demo.data.entites.CompanyAdministrativeInfo;
import com.example.demo.data.models.service.CompanyAdministrativeInfoServiceModel;
import com.example.demo.repositories.CompanyAdministrativeInfoRepository;
import com.example.demo.services.interfaces.CompanyAdministrativeInfoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CompanyAdministrativeInfoServiceImpl implements CompanyAdministrativeInfoService {

    private final ModelMapper modelMapper;
    private final CompanyAdministrativeInfoRepository repository;

    public CompanyAdministrativeInfoServiceImpl(ModelMapper modelMapper, CompanyAdministrativeInfoRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public void saveCompanyAdministrativeInfo(CompanyAdministrativeInfoServiceModel companyAdministrativeInfoServiceModel) {
        CompanyAdministrativeInfo companyAdministrativeInfo = this.modelMapper
                .map(companyAdministrativeInfoServiceModel, CompanyAdministrativeInfo.class);

        this.repository.saveAndFlush(companyAdministrativeInfo);
    }

    @Override
    public boolean checkEmail(String email) {
        CompanyAdministrativeInfo findByEmail = this.repository.findByEmail(email);

        if (findByEmail == null){
            return false;
        }
        return true;
    }
}
