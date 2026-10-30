package HRMS.hrms.organisation.company.controller;


import HRMS.hrms.organisation.company.dto.companyRequestDto;
import HRMS.hrms.organisation.company.dto.companyResponseDto;
import HRMS.hrms.organisation.company.dto.companySetupRequestDto;
import HRMS.hrms.organisation.company.model.companyModel;
import HRMS.hrms.organisation.company.service.companyService;
import HRMS.hrms.organisation.company.service.companyServiceImpl;
import HRMS.hrms.organisation.company.service.companySetUpService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/company/")
public class companyController {
    @Autowired
    private companyServiceImpl companyServiceImpl;
    @Autowired
    private companySetUpService companySetUpService;


    @PostMapping("create")

    public ResponseEntity<Map<String, Object>> createCompanySetup(
            @RequestBody companySetupRequestDto company,
            HttpServletResponse response) {

         Long companyId=companySetUpService.createCompanySetup(company,response);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of(
                        "message", "Company Created Successfully",
                        "data",companyId
                ));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        companyServiceImpl.deleteCompany(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comapny Deleted Successfully");
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody companyRequestDto company){
        companyServiceImpl.updateCompany(id,company);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comapny Updated Successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<companyResponseDto> getCompanyById(
            @PathVariable Long id) {

        companyResponseDto company = companyServiceImpl.getCompanyById(id);

        return ResponseEntity.ok(company);
    }

}
