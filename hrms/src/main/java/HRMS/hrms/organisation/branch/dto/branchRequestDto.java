package HRMS.hrms.organisation.branch.dto;


import HRMS.hrms.organisation.company.model.companyModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class branchRequestDto {



    private String branch_Code;

    private String branch_Name;
    private String branch_Pincode;
    private Boolean branch_Active;

    private String branch_Address;


    private String branch_City;


    private String branch_State;

    private companyModel company_Id;
}

