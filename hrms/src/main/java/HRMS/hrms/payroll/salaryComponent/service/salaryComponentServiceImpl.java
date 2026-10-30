package HRMS.hrms.payroll.salaryComponent.service;


import HRMS.hrms.organisation.branch.model.branchModel;
import HRMS.hrms.organisation.branch.repository.branchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import HRMS.hrms.payroll.salaryComponent.dto.salaryComponentRequestDto;
import HRMS.hrms.payroll.salaryComponent.dto.salaryComponentResponseDto;
import HRMS.hrms.payroll.salaryComponent.mapper.salaryComponentToDtoMapper;
import HRMS.hrms.payroll.salaryComponent.mapper.salaryComponentToEntityMapper;
import HRMS.hrms.payroll.salaryComponent.model.salaryComponentModel;
import HRMS.hrms.payroll.salaryComponent.repository.salaryComponentRepository;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class salaryComponentServiceImpl implements salaryComponentService {
    private final salaryComponentToDtoMapper salaryComponentToDtoMapper;
    private final salaryComponentToEntityMapper salaryComponentToEntityMapper;
    private final salaryComponentRepository salaryComponentRepository;
    private final branchRepo branchRepo;

    public salaryComponentServiceImpl(
            salaryComponentToDtoMapper salaryComponentToDtoMapper,
            salaryComponentToEntityMapper salaryComponentToEntityMapper,
            salaryComponentRepository salaryComponentRepository,
            branchRepo branchRepo) {
        this.salaryComponentToDtoMapper = salaryComponentToDtoMapper;
        this.salaryComponentToEntityMapper = salaryComponentToEntityMapper;
        this.salaryComponentRepository = salaryComponentRepository;
        this.branchRepo = branchRepo;
    }

    public salaryComponentResponseDto createSalaryComponent(salaryComponentRequestDto component){
        if (component == null || component.getBranchId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Branch ID is required");
        }
        branchModel branch = branchRepo.findById(component.getBranchId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Branch not found with ID: " + component.getBranchId()));
        salaryComponentModel salaryComponentModel = salaryComponentToEntityMapper.toEntity(component);
        salaryComponentModel.setBranch_Id(branch);
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
        branchRepo.findById(branchId).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Branch not found with ID: " + branchId));
        List<salaryComponentModel> allSalaryComponentModel=salaryComponentRepository.findByBranchId(branchId);
        return allSalaryComponentModel.stream()
                .map(salaryComponentToDtoMapper::toDto)
                .toList();
    }






    public    salaryComponentResponseDto updateSalaryComponent(
            Long id, salaryComponentRequestDto component
    ){
        salaryComponentModel existing = salaryComponentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Salary component not found with ID: " + id));
        if (component == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Salary component request cannot be null");
        }
        if (component.getBranchId() != null
                && (existing.getBranch_Id() == null
                || !component.getBranchId().equals(existing.getBranch_Id().getBranch_Id()))) {
            branchModel branch = branchRepo.findById(component.getBranchId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Branch not found with ID: " + component.getBranchId()));
            existing.setBranch_Id(branch);
        }
        if (component.getSalaryComponent_Name() != null) {
            existing.setSalaryComponent_Name(component.getSalaryComponent_Name());
        }
        if (component.getSalaryComponent_Code() != null) {
            existing.setSalaryComponent_Code(component.getSalaryComponent_Code());
        }
        if (component.getSalaryComponent_Type() != null) {
            existing.setSalaryComponent_Type(component.getSalaryComponent_Type());
        }
        if (component.getSalaryComponent_CalculationType() != null) {
            existing.setSalaryComponent_CalculationType(component.getSalaryComponent_CalculationType());
        }
        if (component.getSalaryComponent_Value() != null) {
            existing.setSalaryComponent_Value(component.getSalaryComponent_Value());
        }
        if (component.getSalaryComponent_Active() != null) {
            existing.setSalaryComponent_Active(component.getSalaryComponent_Active());
        }
        return salaryComponentToDtoMapper.toDto(salaryComponentRepository.save(existing));
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
