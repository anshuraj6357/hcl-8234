
package payroll.salaryComponent.service;

import java.util.List;

import payroll.salaryComponent.dto.salaryComponentRequestDto;
import payroll.salaryComponent.dto.salaryComponentResponseDto;
import payroll.salaryComponent.model.salaryComponentModel;

public interface salaryComponentService {

    salaryComponentResponseDto createSalaryComponent(salaryComponentRequestDto component);

    List<salaryComponentResponseDto> getAllSalaryComponentsByBranch(Long branchId);

    salaryComponentResponseDto getSalaryComponentById(Long id);

    salaryComponentResponseDto updateSalaryComponent(
            Long id, salaryComponentRequestDto component
    );

    void deleteSalaryComponent(Long id);
}
