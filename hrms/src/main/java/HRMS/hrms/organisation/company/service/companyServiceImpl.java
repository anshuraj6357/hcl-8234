package HRMS.hrms.organisation.company.service;

import HRMS.hrms.organisation.company.Repository.companyRepository;
import HRMS.hrms.organisation.company.dto.companyRequestDto;
import HRMS.hrms.organisation.company.dto.companyResponseDto;
import HRMS.hrms.organisation.company.exception.companyNotCreatedException;
import HRMS.hrms.organisation.company.exception.companyNotFoundException;
import HRMS.hrms.organisation.company.mapper.companyEntityMapper;
import HRMS.hrms.organisation.company.mapper.companyToDtoMapper;
import HRMS.hrms.organisation.company.mapper.companyToUpdateMapper;
import HRMS.hrms.organisation.company.model.companyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class companyServiceImpl implements companyService {

    @Autowired
    private companyEntityMapper companyEntityMapper;
    @Autowired
    private companyRepository companyRepository;
    @Autowired
    private companyToDtoMapper companyToDtoMapper;
    @Autowired
    private companyToUpdateMapper companyToUpdateMapper;



    public companyModel createCompany(companyRequestDto company) throws companyNotCreatedException {
        if (company == null) {
            throw new companyNotCreatedException("Company request cannot be null");
        }

        companyModel newCompany = companyEntityMapper.toEntity(company);
        return companyRepository.save(newCompany);
    }

    @Override
    @Transactional(readOnly = true)
    public companyResponseDto getCompanyById(Long id) {
        companyModel company = companyRepository.findById(id).orElseThrow(()->
                new companyNotFoundException("Company Not Found With This Exception "));
        return companyToDtoMapper.toDto(company);
    }

    @Override
    @Transactional
    public companyResponseDto updateCompany(Long id, companyRequestDto company) {
        if (company == null) {
            throw new companyNotCreatedException("Company request cannot be null");
        }
        companyModel existingCompany = companyRepository.findById(id).orElseThrow(()->
                new companyNotFoundException("Company Not Found With This Exception "));
        companyToUpdateMapper.toUpdateCompany(company, existingCompany);
        return companyToDtoMapper.toDto(companyRepository.save(existingCompany));
    }

    @Override
    public void deleteCompany(Long id) throws companyNotFoundException {
        companyModel company = companyRepository.findById(id).orElseThrow(()->
                new companyNotFoundException("Company not found with ID: " + id));
        companyRepository.delete(company);
    }
}
