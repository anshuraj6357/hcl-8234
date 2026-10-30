package HRMS.hrms.organisation.designation.service;

import HRMS.hrms.organisation.department.model.departmentModel;
import HRMS.hrms.organisation.department.repository.departmentRepo;
import HRMS.hrms.organisation.designation.dto.designationRequestDto;
import HRMS.hrms.organisation.designation.dto.designationResponseDto;
import HRMS.hrms.organisation.designation.exception.designationDepartmentNotFound;
import HRMS.hrms.organisation.designation.exception.designationNotFoundException;
import HRMS.hrms.organisation.designation.mapper.designatoinToUpdateMapper;
import HRMS.hrms.organisation.designation.mapper.designationtoDtoMapper;
import HRMS.hrms.organisation.designation.mapper.designationtoEntityMapper;
import HRMS.hrms.organisation.designation.model.designationModel;
import HRMS.hrms.organisation.designation.repository.designationRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class designationServiceImpl implements designationService{

    private final designationRepo designationRepo;
    private final departmentRepo departmentRepo;
    private final designationtoEntityMapper designationtoEntityMapper;
    private final designationtoDtoMapper designationtoDtoMapper;
    private final designatoinToUpdateMapper designatoinToUpdateMapper;

    public designationServiceImpl(
            designationRepo designationRepo,
            departmentRepo departmentRepo,
            designationtoEntityMapper designationtoEntityMapper,
            designationtoDtoMapper designationtoDtoMapper,
            designatoinToUpdateMapper designatoinToUpdateMapper) {
        this.designationRepo = designationRepo;
        this.departmentRepo = departmentRepo;
        this.designationtoEntityMapper = designationtoEntityMapper;
        this.designationtoDtoMapper = designationtoDtoMapper;
        this.designatoinToUpdateMapper = designatoinToUpdateMapper;
    }

    @Override
    @Transactional
    public designationResponseDto createDesignation(
            designationRequestDto request
    ){
        if (request == null || request.getDepartmentId() == null) {
            throw new IllegalArgumentException("Designation request and department ID are required");
        }
        departmentModel department = departmentRepo.findById(Math.toIntExact(request.getDepartmentId()))
                .orElseThrow(() ->
                        new designationDepartmentNotFound("Department not found with this id"));
        designationModel designation = designationtoEntityMapper.toEntity(request, department);
        return designationtoDtoMapper.toDto(designationRepo.save(designation));
    }

    @Override
    public List<designationResponseDto> getAllDesignations() {
        return designationRepo.findAll().stream()
                .map(designationtoDtoMapper::toDto)
                .toList();
    }

    @Override
    public designationResponseDto getDesignationById(Long id){
        designationModel designation = designationRepo.findById(id)
                .orElseThrow(() ->
                        new designationNotFoundException("Designation not found with this id: " + id));
        return designationtoDtoMapper.toDto(designation);
    }

    @Override
    @Transactional
    public designationResponseDto updateDesignation(
            Long id,
            designationRequestDto request
    ){
        if (request == null) {
            throw new IllegalArgumentException("Designation request cannot be null");
        }
        designationModel designation = designationRepo.findById(id)
                .orElseThrow(() ->
                        new designationNotFoundException("Designation not found with this id: " + id));
        designatoinToUpdateMapper.toUpdate(request, designation);
        if (request.getDepartmentId() != null
                && !request.getDepartmentId().equals(designation.getDepartment().getDepartment_Id())) {
            departmentModel department = departmentRepo.findById(Math.toIntExact(request.getDepartmentId()))
                    .orElseThrow(() ->
                            new designationDepartmentNotFound("Department not found with this id"));
            designation.setDepartment(department);
        }
        return designationtoDtoMapper.toDto(designationRepo.save(designation));
    }

    @Override
    public   void deleteDesignation(Long id){
        designationModel designation = designationRepo.findById(id)
                .orElseThrow(() ->
                        new designationNotFoundException("Designation not found with this id: " + id));
        designationRepo.delete(designation);
    }

    @Override
    public List<designationResponseDto> getDesignationsByDepartmentId(
            Long departmentId
    ){
        return designationRepo.findByDepartmentId(Math.toIntExact(departmentId)).stream()
                .map(designationtoDtoMapper::toDto)
                .toList();
    }

}
