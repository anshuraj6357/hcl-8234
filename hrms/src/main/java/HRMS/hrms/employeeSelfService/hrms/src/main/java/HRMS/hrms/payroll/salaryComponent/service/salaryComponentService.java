
package HRMS.hrms.payroll.salaryComponent.service;

import java.util.List;

import HRMS.hrms.payroll.salaryComponent.dto.salaryComponentRequestDto;
import HRMS.hrms.payroll.salaryComponent.dto.salaryComponentResponseDto;

public interface salaryComponentService {

    salaryComponentResponseDto createSalaryComponent(salaryComponentRequestDto component);

    List<salaryComponentResponseDto> getAllSalaryComponentsByBranch(Long branchId);

    salaryComponentResponseDto getSalaryComponentById(Long id);

    salaryComponentResponseDto updateSalaryComponent(
            Long id, salaryComponentRequestDto component
    );

    void deleteSalaryComponent(Long id);
}
