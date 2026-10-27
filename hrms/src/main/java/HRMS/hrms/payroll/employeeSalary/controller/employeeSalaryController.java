
package HRMS.hrms.payroll.employeeSalary.controller;

import HRMS.hrms.payroll.employeeSalary.dto.employeeSalaryRequestDto;
import HRMS.hrms.payroll.employeeSalary.dto.employeeSalaryResponseDto;
import HRMS.hrms.payroll.employeeSalary.service.employeeSalaryService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee-salaries")
@RequiredArgsConstructor
public class employeeSalaryController {

    private final employeeSalaryService employeeSalaryService;

    // 1. Assign salary to an employee
    @PostMapping("/create")
    public ResponseEntity<employeeSalaryResponseDto> createEmployeeSalary(
            @RequestBody employeeSalaryRequestDto dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeSalaryService.createEmployeeSalary(dto));
    }

    // 2. Get all employee salary records
    @GetMapping("getAllEmployeesSalary")
    public ResponseEntity<List<employeeSalaryResponseDto>> getAllEmployeeSalaries() {

        return ResponseEntity.ok(
                employeeSalaryService.getAllEmployeeSalaries());
    }

    // 3. Get employee salary record by ID
    @GetMapping("/{id}")
    public ResponseEntity<employeeSalaryResponseDto> getEmployeeSalaryById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                employeeSalaryService.getEmployeeSalaryById(id));
    }

    // 4. Get salary records for a particular employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<employeeSalaryResponseDto>> getByEmployeeId(
            @PathVariable Long employeeId) {

        return ResponseEntity.ok(
                employeeSalaryService.getSalariesByEmployeeId(employeeId));
    }

    // 5. Update employee salary
    @PutMapping("/{id}")
    public ResponseEntity<employeeSalaryResponseDto> updateEmployeeSalary(
            @PathVariable Long id,
            @RequestBody employeeSalaryRequestDto dto) {

        return ResponseEntity.ok(
                employeeSalaryService.updateEmployeeSalary(id, dto));
    }

    // 6. Delete employee salary record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeSalary(
            @PathVariable Long id) {

        employeeSalaryService.deleteEmployeeSalary(id);

        return ResponseEntity.noContent().build();
    }
}
