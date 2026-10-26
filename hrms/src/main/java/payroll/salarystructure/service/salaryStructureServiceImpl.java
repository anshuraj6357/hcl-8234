package payroll.salarystructure.service;


import HRMS.hrms.employee.model.employeeModel;
import HRMS.hrms.employee.repository.employeeRepo;
import HRMS.hrms.organisation.branch.model.branchModel;
import HRMS.hrms.organisation.branch.repository.branchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payroll.salarystructure.dto.salaryStructureRequestDto;
import payroll.salarystructure.dto.salaryStructureResponseDto;
import payroll.salarystructure.mapper.salaryStructureToDtoMapper;
import payroll.salarystructure.mapper.salaryStructureToEntityMapper;
import payroll.salarystructure.model.salaryStructureModel;
import payroll.salarystructure.repository.salaryStructureRepository;

import java.util.List;

@Service
public class salaryStructureServiceImpl implements salaryStructureService {


    @Autowired
    private branchModel branchModel;
    private branchRepo branchRepo;
    private employeeModel employeeModel;
    private employeeRepo employeeRepo;
    private salaryStructureRepository salaryStructureRepository;


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





    public List<salaryStructureResponseDto> getAllSalaryStructuresByCompany(
            Long companyId
    ){
        return null;
    }

    public salaryStructureResponseDto getSalaryStructureById(
            Long id
    ){
        return null;
    }
    public salaryStructureResponseDto updateSalaryStructure(
            Long id,
            salaryStructureRequestDto request
    ){
        return null;
    }

    public void deleteSalaryStructure(Long id){

    }
}
