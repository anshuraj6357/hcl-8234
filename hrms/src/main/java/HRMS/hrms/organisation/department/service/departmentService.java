
package HRMS.hrms.organisation.department.service;

import HRMS.hrms.organisation.department.dto.departmentRequestDto;
import HRMS.hrms.organisation.department.dto.departmentResponseDto;

import java.util.List;

public interface departmentService {

    // Create a new department
    departmentResponseDto createDepartment(departmentRequestDto department,Long companyId);

    // Fetch all departments
    List<departmentResponseDto> getAllDepartmentsByCompanyId(Long Id);


    // Update department
    departmentResponseDto updateDepartment(
            Long id,
            departmentRequestDto department
    );

    // Delete department
    void deleteDepartment(Long id);

    // Fetch all departments belonging to a company
    List<departmentResponseDto> getDepartmentsByCompanyId(Long companyId);
}
