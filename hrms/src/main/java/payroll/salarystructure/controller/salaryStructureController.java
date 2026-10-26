
package payroll.salarystructure.controller;

import payroll.salarystructure.service.salaryStructureService;
import payroll.salarystructure.dto.salaryStructureRequestDto;
import payroll.salarystructure.dto.salaryStructureResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary-structures")
public class salaryStructureController {

    private final salaryStructureService salaryStructureService;

    public salaryStructureController(
            salaryStructureService salaryStructureService) {
        this.salaryStructureService = salaryStructureService;
    }

    // Create Salary Structure
    @PostMapping
    public ResponseEntity<salaryStructureResponseDto> createSalaryStructure(
            @RequestBody salaryStructureRequestDto request) {

        salaryStructureResponseDto response =
                salaryStructureService.createSalaryStructure(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Get All Salary Structures By Company
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<salaryStructureResponseDto>>
    getAllSalaryStructuresByCompany(@PathVariable Long companyId) {

        List<salaryStructureResponseDto> response =
                salaryStructureService
                        .getAllSalaryStructuresByCompany(companyId);

        return ResponseEntity.ok(response);
    }

    // Get Salary Structure By ID
    @GetMapping("/{id}")
    public ResponseEntity<salaryStructureResponseDto>
    getSalaryStructureById(@PathVariable Long id) {

        salaryStructureResponseDto response =
                salaryStructureService.getSalaryStructureById(id);

        return ResponseEntity.ok(response);
    }

    // Update Salary Structure
    @PutMapping("/{id}")
    public ResponseEntity<salaryStructureResponseDto> updateSalaryStructure(
            @PathVariable Long id,
            @RequestBody salaryStructureRequestDto request) {

        salaryStructureResponseDto response =
                salaryStructureService.updateSalaryStructure(id, request);

        return ResponseEntity.ok(response);
    }

    // Delete Salary Structure
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalaryStructure(
            @PathVariable Long id) {

        salaryStructureService.deleteSalaryStructure(id);

        return ResponseEntity.noContent().build();
    }
}
