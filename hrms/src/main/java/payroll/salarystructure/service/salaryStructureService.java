
package payroll.salarystructure.service;

import payroll.salarystructure.dto.salaryStructureRequestDto;
import payroll.salarystructure.dto.salaryStructureResponseDto;

import java.util.List;



public interface salaryStructureService {

    // Create salary structure
    salaryStructureResponseDto createSalaryStructure(
            salaryStructureRequestDto request
    );

    // Get all salary structures of a company
    List<salaryStructureResponseDto> getAllSalaryStructuresByCompany(
            Long companyId
    );

    // Get salary structure by ID
    salaryStructureResponseDto getSalaryStructureById(
            Long id
    );

    // Update salary structure
    salaryStructureResponseDto updateSalaryStructure(
            Long id,
            salaryStructureRequestDto request
    );

    // Delete (or deactivate) salary structure
    void deleteSalaryStructure(Long id);
}
