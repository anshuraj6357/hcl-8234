package HRMS.hrms.payroll.salarystructure.service;


import HRMS.hrms.employee.model.employeeModel;
import HRMS.hrms.employee.repository.employeeRepo;
import HRMS.hrms.organisation.branch.model.branchModel;
import HRMS.hrms.organisation.branch.repository.branchRepo;
import HRMS.hrms.organisation.department.repository.departmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import HRMS.hrms.payroll.salarystructure.dto.salaryStructureRequestDto;
import HRMS.hrms.payroll.salarystructure.dto.salaryStructureResponseDto;
import HRMS.hrms.payroll.salarystructure.mapper.salaryStructureToUpdateEntityMapper;
import HRMS.hrms.payroll.salarystructure.mapper.salaryStructureToDtoMapper;
import HRMS.hrms.payroll.salarystructure.mapper.salaryStructureToEntityMapper;
import HRMS.hrms.payroll.salarystructure.model.salaryStructureModel;
import HRMS.hrms.payroll.salarystructure.repository.salaryStructureRepository;

import java.util.List;

@Service
public class salaryStructureServiceImpl implements salaryStructureService {


    @Autowired
    private branchRepo branchRepo;
    private employeeModel employeeModel;
    private employeeRepo employeeRepo;
    private salaryStructureRepository salaryStructureRepository;
    private departmentRepo departmentRepository;
    private salaryStructureToUpdateEntityMapper salaryStructureToUpdateEntityMapper;


    @Override
    public salaryStructureResponseDto createSalaryStructure(
            salaryStructureRequestDto request) {

        if (request == null) {
            throw new RuntimeException("Request cannot be null");
        }

        // Fetch branch from database
        branchModel branch = branchRepo.findById(
                request.getBranch_Id()
        ).orElseThrow(() ->
                new RuntimeException("Branch not found")
        );

        // Fetch employee from database, if provided
        employeeModel employee = null;

        if (request.getEmployee_Id() != null) {
            employee = employeeRepo.findById(
                    request.getEmployee_Id()
            ).orElseThrow(() ->
                    new RuntimeException("Employee not found")
            );
        }

        // Convert DTO to Entity
        salaryStructureModel model =
                salaryStructureToEntityMapper.toEntity(
                        request, branch, employee
                );

        // Save entity
        salaryStructureModel savedModel =
                salaryStructureRepository.save(model);

        // Convert Entity to Response DTO
        return salaryStructureToDtoMapper.toDto(savedModel);
    }





    public List<salaryStructureResponseDto> getAllSalaryStructuresByBranch(
            Long branchId
    ){



        List<salaryStructureModel> allSalaryStructures=salaryStructureRepository.findAll().
                stream().filter(
                        salaryStructureModel ->
                                salaryStructureModel.getBranch_Id() != null
                                        &&
                                salaryStructureModel.getBranch_Id().equals(branchId)
                )
                .toList();

 return allSalaryStructures.
         stream().
         map(salaryStructureToDtoMapper::toDto)
         .toList();


    }


    @Override
    public salaryStructureResponseDto getSalaryStructureById(Long id) {

        salaryStructureModel model =
                salaryStructureRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Salary Structure not found with ID: " + id
                                )
                        );

        return salaryStructureToDtoMapper.toDto(model);
    }




    @Override
    public salaryStructureResponseDto updateSalaryStructure(
            Long id,
            salaryStructureRequestDto request) {

        salaryStructureModel model =
                salaryStructureRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Salary Structure not found with ID: " + id
                                )
                        );

        // Update entity using mapper
        salaryStructureModel updatedModel =
                salaryStructureToUpdateEntityMapper.toUpdateEntity(
                        model, request);

        // Save updated entity
        salaryStructureModel savedModel =
                salaryStructureRepository.save(updatedModel);

        // Convert entity to response DTO
        return salaryStructureToDtoMapper.toDto(savedModel);
    }


    @Override
    public void deleteSalaryStructure(Long id) {

        salaryStructureModel model =
                salaryStructureRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Salary Structure not found with ID: " + id
                                )
                        );

        salaryStructureRepository.delete(model);
    }

}
