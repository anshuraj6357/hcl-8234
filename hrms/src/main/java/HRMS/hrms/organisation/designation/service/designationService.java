
package HRMS.hrms.organisation.designation.service;

import HRMS.hrms.organisation.designation.dto.designationRequestDto;
import HRMS.hrms.organisation.designation.dto.designationResponseDto;

import java.util.List;

public interface designationService {

    // Create designation
    designationResponseDto createDesignation(
            designationRequestDto designationRequestDto
    );

    // Get all designations
    List<designationResponseDto> getAllDesignations();

    // Get designation by ID
    designationResponseDto getDesignationById(Long id);

    // Update designation
    designationResponseDto updateDesignation(
            Long id,
            designationRequestDto designationRequestDto
    );

    // Delete designation
    void deleteDesignation(Long id);

    // Get designations by department ID
    List<designationResponseDto> getDesignationsByDepartmentId(
            Long departmentId
    );
}
