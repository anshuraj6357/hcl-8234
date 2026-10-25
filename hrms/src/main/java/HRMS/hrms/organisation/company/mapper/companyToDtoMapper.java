package HRMS.hrms.organisation.company.mapper;

import HRMS.hrms.organisation.company.dto.companyResponseDto;
import HRMS.hrms.organisation.company.model.companyModel;
import org.springframework.stereotype.Component;


@Component
public class companyToDtoMapper {

    public companyResponseDto toDto(companyModel company){
        companyResponseDto dto = new companyResponseDto();


        dto.setCompany_Name(company.getCompany_Name());
        dto.setCompany_Code(company.getCompany_Code());
        dto.setCompany_Address(company.getCompany_Address());
        dto.setCompany_Email(company.getCompany_Email());
        dto.setCompany_Phone(company.getCompany_Phone());
        dto.setCompany_Active(company.getCompany_Active());
        return dto;

    }
}
