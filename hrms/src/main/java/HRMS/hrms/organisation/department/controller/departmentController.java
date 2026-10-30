package HRMS.hrms.organisation.department.controller;


import HRMS.hrms.organisation.department.dto.departmentRequestDto;
import HRMS.hrms.organisation.department.dto.departmentResponseDto;
import HRMS.hrms.organisation.department.service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department/")
public class departmentController {

    @Autowired
    private departmentService departmentService;


    @PostMapping("create/{companyId}")
    public ResponseEntity<departmentResponseDto> createDepartment(@RequestBody departmentRequestDto departmentRequestDto,
                                                                  @PathVariable Long companyId){
        departmentResponseDto department=departmentService.createDepartment(departmentRequestDto,companyId);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(department);
    }


    @GetMapping("company/{companyId}")
    public ResponseEntity<List<departmentResponseDto>>
    getDepartmentsByCompanyId(@PathVariable Long companyId) {

        List<departmentResponseDto> departments =
                departmentService.getDepartmentsByCompanyId(companyId);

        return ResponseEntity.ok(departments);
    }

    @PutMapping("update/{departmentId}")
    public ResponseEntity<departmentResponseDto> updateDepartment(
            @PathVariable Integer departmentId,
            @RequestBody departmentRequestDto department) {
        return ResponseEntity.ok(
                departmentService.updateDepartment(departmentId, department));
    }

    @DeleteMapping("delete/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Department Deleted");
    }

}
