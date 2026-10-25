
package HRMS.hrms.employee.controller;

import HRMS.hrms.employee.dto.employeeDto;
import HRMS.hrms.employee.exception.employeeNotFound;
import HRMS.hrms.employee.service.employeeServiceImpl;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class employeeController {

    @Autowired
    private  employeeServiceImpl employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<employeeDto> createEmployee(
            @Valid @RequestBody employeeDto dto) {

        employeeDto savedEmployee = employeeService.createEmployee(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedEmployee);
    }

    @GetMapping("/getEmployeeById")
    public ResponseEntity<employeeDto> getEmployeeById(
            @RequestParam Long id) throws employeeNotFound {
        return ResponseEntity.ok(
                employeeService.getEmployeeById(id));
    }

    @PatchMapping("/updateEmployee")
    public ResponseEntity<String> updateEmployee(
            @RequestParam Long id,
             @RequestBody employeeDto dto)
            throws employeeNotFound {

        employeeService.updateEmployee(id, dto);

        return ResponseEntity.ok("Employee updated successfully");
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<employeeDto>> getAllEmployees() throws employeeNotFound {
        return ResponseEntity.ok(
                employeeService.getAllEmployees());
    }

    @GetMapping("/getEmployeesByDepartment")
    public ResponseEntity<List<employeeDto>> getEmployeesByDepartment(
            @RequestParam String department)
            throws employeeNotFound {

        return ResponseEntity.ok(
                employeeService.getEmployeesByDepartment(department));
    }

    @GetMapping("/getEmployeesByDesignation")
    public ResponseEntity<List<employeeDto>> getEmployeesByDesignation(
            @RequestParam String designation)
            throws employeeNotFound {

        return ResponseEntity.ok(
                employeeService.getEmployeesByDesignation(designation));
    }

    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<String> deleteEmployee(
            @RequestParam Long id) throws employeeNotFound {

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok("Employee deleted successfully");
    }
}
