
package HRMS.hrms.organisation.designation.controller;

import HRMS.hrms.organisation.designation.dto.designationRequestDto;
import HRMS.hrms.organisation.designation.dto.designationResponseDto;
import HRMS.hrms.organisation.designation.service.designationService;

import HRMS.hrms.organisation.designation.service.designationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/designations")
public class designationController {

    @Autowired
    private  designationServiceImpl designationService;



    // Create designation
    @PostMapping("/create")
    public ResponseEntity<designationResponseDto> createDesignation(
            @RequestBody designationRequestDto dto) {

        designationResponseDto designation =
                designationService.createDesignation(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(designation);
    }

    // Get all designations
    @GetMapping("/getAll")
    public ResponseEntity<List<designationResponseDto>> getAllDesignations() {

        return ResponseEntity.ok(
                designationService.getAllDesignations()
        );
    }

    // Get designation by ID
    @GetMapping("/{id}")
    public ResponseEntity<designationResponseDto> getDesignationById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                designationService.getDesignationById(id)
        );
    }

    // Update designation
    @PutMapping("/update/{id}")
    public ResponseEntity<designationResponseDto> updateDesignation(
            @PathVariable Long id,
            @RequestBody designationRequestDto dto) {

        return ResponseEntity.ok(
                designationService.updateDesignation(id, dto)
        );
    }

    // Delete designation
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDesignation(
            @PathVariable Long id) {

        designationService.deleteDesignation(id);

        return ResponseEntity.noContent().build();
    }

    // Get designations by department ID
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<designationResponseDto>>
    getDesignationsByDepartmentId(
            @PathVariable Long departmentId) {

        return ResponseEntity.ok(
                designationService.getDesignationsByDepartmentId(departmentId)
        );
    }
}
