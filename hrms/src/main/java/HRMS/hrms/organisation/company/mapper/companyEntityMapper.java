package HRMS.hrms.organisation.company.mapper;

import HRMS.hrms.organisation.company.dto.companyRequestDto;
import HRMS.hrms.organisation.company.model.companyModel;

public class companyEntityMapper {

    public companyModel toEntity(companyRequestDto company){

        companyModel companymodel= new companyModel();
        companymodel.setCompany_Name(company.getCompany_Name());
        companymodel.setCompany_Code(company.getCompany_Code());
        companymodel.setCompany_Email(company.getCompany_Email());
        companymodel.setCompany_Phone(company.getCompany_Phone());
        companymodel.setCompany_Address(company.getCompany_Address());
        companymodel.setCompany_Active(true);
        return companymodel;
    }
}
