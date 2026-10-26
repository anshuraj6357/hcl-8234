
package payroll.salaryComponent.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import payroll.salaryComponent.dto.salaryComponentRequestDto;
import payroll.salaryComponent.dto.salaryComponentResponseDto;
import payroll.salaryComponent.service.salaryComponentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salary-components")
@RequiredArgsConstructor
public class salaryComponentController {
    @Autowired
    private final salaryComponentService salaryComponentService;

    // Get all salary components
    @GetMapping("/{companyId}/{BranchId}")
    public ResponseEntity<List<salaryComponentResponseDto>> getAllSalaryComponents(
            @PathVariable Long CompanyId,@PathVariable Long BranchId
    ) {
        return ResponseEntity.ok(
                salaryComponentService.getAllSalaryComponentsByBranch(BranchId)
        );
    }

    // Get salary component by ID
    @GetMapping("/{id}")
    public ResponseEntity<salaryComponentResponseDto> getSalaryComponentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                salaryComponentService.getSalaryComponentById(id)
        );
    }

    // Create salary component
    @PostMapping
    public ResponseEntity<salaryComponentResponseDto> createSalaryComponent(
            @RequestBody salaryComponentRequestDto requestDto) {

        salaryComponentResponseDto response =
                salaryComponentService.createSalaryComponent(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Update salary component
    @PutMapping("/{id}")
    public ResponseEntity<salaryComponentResponseDto> updateSalaryComponent(
            @PathVariable Long id,
            @RequestBody salaryComponentRequestDto requestDto) {

        return ResponseEntity.ok(
                salaryComponentService.updateSalaryComponent(id, requestDto)
        );
    }

    // Delete salary component
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalaryComponent(
            @PathVariable Long id) {

        salaryComponentService.deleteSalaryComponent(id);
        return ResponseEntity.noContent().build();
    }
}
