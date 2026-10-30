package HRMS.hrms.payroll.salarystructure.service;


import HRMS.hrms.organisation.branch.model.branchModel;
import HRMS.hrms.organisation.branch.repository.branchRepo;
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
    @Autowired
    private salaryStructureRepository salaryStructureRepository;


    @Override
    public salaryStructureResponseDto createSalaryStructure(
            salaryStructureRequestDto request) {

        if (request == null) {
            throw new RuntimeException("Request cannot be null");
        }
        if (request.getBranch_Id() == null) {
            throw new RuntimeException("Branch ID is required");
        }

        // Fetch branch from database
        branchModel branch = branchRepo.findById(
                request.getBranch_Id()
        ).orElseThrow(() ->
                new RuntimeException("Branch not found")
        );

        // Convert DTO to Entity
        salaryStructureModel model =
                salaryStructureToEntityMapper.toEntity(
                        request, branch
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



        branchRepo.findById(branchId).orElseThrow(() ->
                new RuntimeException("Branch not found with ID: " + branchId));
        return salaryStructureRepository.findByBranchId(branchId)
                .stream()
                .map(salaryStructureToDtoMapper::toDto)
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
        if (request == null) {
            throw new RuntimeException("Request cannot be null");
        }

        salaryStructureModel model =
                salaryStructureRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Salary Structure not found with ID: " + id
                                )
                        );

        salaryStructureToUpdateEntityMapper.toUpdateEntity(model, request);
        if (request != null && request.getBranch_Id() != null
                && (model.getBranch_Id() == null
                || !request.getBranch_Id().equals(model.getBranch_Id().getBranch_Id()))) {
            branchModel branch = branchRepo.findById(request.getBranch_Id())
                    .orElseThrow(() ->
                            new RuntimeException("Branch not found with ID: " + request.getBranch_Id()));
            model.setBranch_Id(branch);
        }

        // Save updated entity
        salaryStructureModel savedModel =
                salaryStructureRepository.save(model);

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
