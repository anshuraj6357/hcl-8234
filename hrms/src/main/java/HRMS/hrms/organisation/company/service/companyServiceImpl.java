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

import java.util.List;

@Service
public class companyServiceImpl implements companyService {

    @Autowired
    private companyEntityMapper companyEntityMapper;
    private companyRepository companyRepository;
    private companyToDtoMapper companyToDtoMapper;
    private companyToUpdateMapper companyToUpdateMapper;

    public companyResponseDto createCompany(companyRequestDto company)throws companyNotCreatedException {
        try{

            companyModel createCompany = companyEntityMapper.toEntity(company);

            companyModel savedCompany=companyRepository.save(createCompany);

            companyResponseDto companyResponseDto = companyToDtoMapper.toDto(savedCompany);

            return companyResponseDto;
        }
        catch(companyNotCreatedException e){
            throw new  companyNotCreatedException("due to internal server error ");
        }

    }


//    public List<companyResponseDto> getAllCompanies(){
//
//        return null;
//    }
    public  companyResponseDto getCompanyById(Long id){
        companyModel company = companyRepository.findById(id).orElseThrow(()->
                new companyNotFoundException("Company Not Found With This Exception "));
        companyResponseDto getCompanyById = companyToDtoMapper.toDto(company);
        return getCompanyById;
    }
    public companyResponseDto updateCompany(Long id, companyRequestDto company){

        companyModel existingCompany=companyRepository.findById(id).orElseThrow(()->
                new companyNotFoundException("Company Not Found With This Exception "));
        companyModel companyModel=companyToUpdateMapper.toUpdateCompany(company,existingCompany);

        companyResponseDto companyResponseDto = companyToDtoMapper.toDto(companyModel);

        return companyResponseDto;
    }

    public void deleteCompany(Long id)throws companyNotFoundException{
        companyModel company =companyRepository.findById(id).orElseThrow(()->
         new companyNotFoundException("Company Not Found With this is ")
                );
        companyRepository.delete(company);
    }
//    public  List<companyResponseDto> searchCompanyByName(String name){
//        return null;
//    }
}
