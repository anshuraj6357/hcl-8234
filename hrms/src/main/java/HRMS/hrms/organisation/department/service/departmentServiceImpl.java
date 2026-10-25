package HRMS.hrms.organisation.department.service;

import HRMS.hrms.organisation.company.Repository.companyRepository;
import HRMS.hrms.organisation.company.exception.companyNotFoundException;
import HRMS.hrms.organisation.company.model.companyModel;
import HRMS.hrms.organisation.department.dto.departmentRequestDto;
import HRMS.hrms.organisation.department.dto.departmentResponseDto;
import HRMS.hrms.organisation.department.exception.departmentNotFoundException;
import HRMS.hrms.organisation.department.mapper.departmentToDtoMapper;
import HRMS.hrms.organisation.department.mapper.departmentToEntityMapper;
import HRMS.hrms.organisation.department.model.departmentModel;
import HRMS.hrms.organisation.department.repository.departmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class departmentServiceImpl implements departmentService {

    @Autowired
    private departmentRepo departmentRepo;
    private companyRepository companyRepo;
    private departmentToEntityMapper departmentToEntityMapper;
    private departmentToDtoMapper departmentToDtoMapper;



    public departmentResponseDto createDepartment(departmentRequestDto department,Long company_id) {

        companyModel company =companyRepo.findById(company_id).orElseThrow(()->
                new companyNotFoundException("company Not Found"));
        departmentModel departmentModel=departmentToEntityMapper.toEntity(department,company);
        departmentRepo.save(departmentModel);
        departmentResponseDto departmentResponseDto=departmentToDtoMapper.departmentToDto(departmentModel);
        return departmentResponseDto;

    }

    @Override
    public List<departmentResponseDto> getAllDepartmentsByCompanyId(Long id) {

        return departmentRepo.findAll()
                .stream()
                .filter(department ->
                        department.getCompany().getCompany_Id().equals(id)
                )
                .map(departmentToDtoMapper::departmentToDto)
                .toList();
    }

    public void deleteDepartment(Integer id) {
        departmentModel departmentModel=departmentRepo.findById(id).orElseThrow(()->
                new departmentNotFoundException("Department not found with this id "));

        departmentRepo.delete(departmentModel);

    }
    public  departmentResponseDto updateDepartment(
            Long id,
            departmentRequestDto department
    ){
        return null;
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
