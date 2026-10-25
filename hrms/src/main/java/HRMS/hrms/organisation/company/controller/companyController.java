package HRMS.hrms.organisation.company.controller;


import HRMS.hrms.organisation.company.dto.companyRequestDto;
import HRMS.hrms.organisation.company.model.companyModel;
import HRMS.hrms.organisation.company.service.companyService;
import HRMS.hrms.organisation.company.service.companyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comapny/")
public class companyController {
    @Autowired
    private companyServiceImpl companyServiceImpl;


    @PostMapping("create")
    public ResponseEntity<String> createCompany(@RequestBody companyRequestDto company){
        companyServiceImpl.createCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body("Comapny Created SuccessFully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        companyServiceImpl.deleteCompany(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comapny Deleted Successfully");
    }
    @PatchMapping("/update")
    public ResponseEntity<String> updateCompany(@PathVariable Long Id,@RequestBody companyRequestDto company){
        companyServiceImpl.updateCompany(Id,company);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comapny Updated Successfully");
    }

}
