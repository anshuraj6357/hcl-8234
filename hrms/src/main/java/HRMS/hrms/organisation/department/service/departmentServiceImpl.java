package HRMS.hrms.organisation.department.service;

import HRMS.hrms.organisation.company.Repository.companyRepository;
import HRMS.hrms.organisation.company.exception.companyNotFoundException;
import HRMS.hrms.organisation.company.model.companyModel;
import HRMS.hrms.organisation.department.dto.departmentRequestDto;
import HRMS.hrms.organisation.department.dto.departmentResponseDto;
import HRMS.hrms.organisation.department.exception.departmentNotFoundException;
import HRMS.hrms.organisation.department.mapper.departmentToDtoMapper;
import HRMS.hrms.organisation.department.mapper.departmentToEntityMapper;
import HRMS.hrms.organisation.department.mapper.departmentToUpdateMapper;
import HRMS.hrms.organisation.department.model.departmentModel;
import HRMS.hrms.organisation.department.repository.departmentRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class departmentServiceImpl implements departmentService {

    private final departmentRepo departmentRepo;
    private final companyRepository companyRepo;
    private final departmentToEntityMapper departmentToEntityMapper;
    private final departmentToDtoMapper departmentToDtoMapper;
    private final departmentToUpdateMapper departmentToUpdateMapper;

    public departmentServiceImpl(
            departmentRepo departmentRepo,
            companyRepository companyRepo,
            departmentToEntityMapper departmentToEntityMapper,
            departmentToDtoMapper departmentToDtoMapper,
            departmentToUpdateMapper departmentToUpdateMapper) {
        this.departmentRepo = departmentRepo;
        this.companyRepo = companyRepo;
        this.departmentToEntityMapper = departmentToEntityMapper;
        this.departmentToDtoMapper = departmentToDtoMapper;
        this.departmentToUpdateMapper = departmentToUpdateMapper;
    }

    @Override
    @Transactional
    public departmentResponseDto createDepartment(departmentRequestDto department,Long company_id) {
        if (department == null || company_id == null) {
            throw new IllegalArgumentException("Department request and company ID are required");
        }

        companyModel company = companyRepo.findById(company_id).orElseThrow(()->
                new companyNotFoundException("company Not Found"));
        departmentModel departmentModel=departmentToEntityMapper.toEntity(department,company);
        departmentModel savedDepartment = departmentRepo.save(departmentModel);
        return departmentToDtoMapper.departmentToDto(savedDepartment);

    }

    @Override
    public List<departmentResponseDto> getAllDepartmentsByCompanyId(Long id) {
        return departmentRepo.findDepartmentsByCompanyId(id)
                .stream()
                .map(departmentToDtoMapper::departmentToDto)
                .toList();
    }

    public void deleteDepartment(Integer id) {
        departmentModel departmentModel=departmentRepo.findById(id).orElseThrow(()->
                new departmentNotFoundException("Department not found with this id "));

        departmentRepo.delete(departmentModel);

    }
    public  departmentResponseDto updateDepartment(
            Integer id,
            departmentRequestDto department
    ){
        if (department == null) {
            throw new IllegalArgumentException("Department request cannot be null");
        }
        departmentModel existingDepartment = departmentRepo.findById(id)
                .orElseThrow(() ->
                        new departmentNotFoundException("Department not found with this id"));

        departmentToUpdateMapper.toUpdate(department, existingDepartment);
        if (department.getCompanyId() != null
                && !department.getCompanyId().equals(existingDepartment.getCompany().getCompany_Id())) {
            companyModel company = companyRepo.findById(department.getCompanyId())
                    .orElseThrow(() ->
                            new companyNotFoundException("Company not found with this id"));
            existingDepartment.setCompany(company);
        }
        return departmentToDtoMapper.departmentToDto(departmentRepo.save(existingDepartment));
    }


    @Override
    public List<departmentResponseDto> getDepartmentsByCompanyId(Long companyId) {

        if (!companyRepo.existsById(companyId)) {
            throw new companyNotFoundException(
                    "Company not found with this id: " + companyId
            );
        }

        return departmentRepo.findDepartmentsByCompanyId(companyId)
                .stream()
                .map(departmentToDtoMapper::departmentToDto)
                .toList();
    }


}
