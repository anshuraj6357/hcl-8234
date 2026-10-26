package payroll.salaryComponent.service;


import HRMS.hrms.organisation.branch.model.branchModel;
import HRMS.hrms.organisation.branch.repository.branchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payroll.salaryComponent.dto.salaryComponentRequestDto;
import payroll.salaryComponent.dto.salaryComponentResponseDto;
import payroll.salaryComponent.mapper.salaryComponentToDtoMapper;
import payroll.salaryComponent.mapper.salaryComponentToEntityMapper;
import payroll.salaryComponent.model.salaryComponentModel;
import payroll.salaryComponent.repository.salaryComponentRepository;

import java.util.List;

@Service
public class salaryComponentServiceImpl implements salaryComponentService {
    @Autowired
    private salaryComponentToDtoMapper salaryComponentToDtoMapper;
    private salaryComponentToEntityMapper salaryComponentToEntityMapper;
    private salaryComponentRepository salaryComponentRepository;
    private branchRepo branchRepo;
    private branchModel branchModel;



    public salaryComponentResponseDto createSalaryComponent(salaryComponentRequestDto component){
        salaryComponentModel salaryComponentModel = salaryComponentToEntityMapper.toEntity(component);
        salaryComponentModel savedSalaryComponent=salaryComponentRepository.save(salaryComponentModel);
        salaryComponentResponseDto salaryComponentResponseDto=salaryComponentToDtoMapper.toDto(savedSalaryComponent);
        return salaryComponentResponseDto;
    }


    @Override
    public salaryComponentResponseDto getSalaryComponentById(Long id) {

        salaryComponentModel component =
                salaryComponentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Salary Component Not Found With ID: " + id
                                ));

        return salaryComponentToDtoMapper.toDto(component);
    }





    public List<salaryComponentResponseDto> getAllSalaryComponentsByBranch(Long branchId){
        branchModel branch=branchRepo.findById(branchId).orElseThrow(()->
                new RuntimeException("Branch Not Found With This ID"));
        List<salaryComponentModel> allSalaryComponentModel=salaryComponentRepository.findByBranch_Branch_Id(branchId);
        return allSalaryComponentModel.stream()
                .map(salaryComponentToDtoMapper::toDto)
                .toList();
    }






    public    salaryComponentResponseDto updateSalaryComponent(
            Long id, salaryComponentRequestDto component
    ){
        return null;
    }

    @Override
    public void deleteSalaryComponent(Long id) {

        salaryComponentModel component =
                salaryComponentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Salary Component Not Found With ID: " + id
                                ));

        salaryComponentRepository.delete(component);
    }
}
