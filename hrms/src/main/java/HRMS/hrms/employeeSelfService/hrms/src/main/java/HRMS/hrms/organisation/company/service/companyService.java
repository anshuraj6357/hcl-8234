
package HRMS.hrms.organisation.company.service;

import HRMS.hrms.organisation.company.dto.companyRequestDto;
import HRMS.hrms.organisation.company.dto.companyResponseDto;
import HRMS.hrms.organisation.company.exception.companyNotCreatedException;
import HRMS.hrms.organisation.company.model.companyModel;
import java.util.List;

public interface companyService {

    // Create a new company
    companyResponseDto createCompany(companyRequestDto company) throws companyNotCreatedException;

    // Get all companies
//    List<companyResponseDto> getAllCompanies();

    // Get company by ID
    companyResponseDto getCompanyById(Integer id);

    // Update company details
    companyResponseDto updateCompany(Integer id, companyRequestDto company);

    // Delete company by ID
    void deleteCompany(Integer id);

    // Search company by name
//    List<companyResponseDto> searchCompanyByName(String name);

}
