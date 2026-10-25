
package HRMS.hrms.organisation.company.mapper;

import HRMS.hrms.organisation.company.dto.companyRequestDto;
import HRMS.hrms.organisation.company.model.companyModel;
import org.springframework.stereotype.Component;

@Component
public class companyToUpdateMapper {

    public companyModel toUpdateCompany(
            companyRequestDto dto,
            companyModel existingCompany) {

        if (dto.getCompany_Name() != null) {
            existingCompany.setCompany_Name(dto.getCompany_Name());
        }

        if (dto.getCompany_Address() != null) {
            existingCompany.setCompany_Address(dto.getCompany_Address());
        }

        if (dto.getCompany_Code() != null) {
            existingCompany.setCompany_Code(dto.getCompany_Code());
        }

        if (dto.getCompany_Phone() != null) {
            existingCompany.setCompany_Phone(dto.getCompany_Phone());
        }

        if (dto.getCompany_Email() != null) {
            existingCompany.setCompany_Email(dto.getCompany_Email());
        }

        if (dto.getCompany_Active() != null) {
            existingCompany.setCompany_Active(dto.getCompany_Active());
        }

        return existingCompany;
    }
}
