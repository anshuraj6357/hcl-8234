package HRMS.hrms.payroll.salaryComponent.dto;

import lombok.Getter;
import lombok.Setter;
import HRMS.hrms.payroll.salaryComponent.enums.salaryComponentCalculationType;
import HRMS.hrms.payroll.salaryComponent.enums.salaryComponentType;


@Getter
@Setter
public class salaryComponentResponseDto {

    private String salaryComponent_Name;
    private salaryComponentType salaryComponent_Type;
    private Double salaryComponent_Value;
    private String salaryComponent_Code;
    private Boolean salaryComponent_Active;
    private salaryComponentCalculationType salaryComponent_CalculationType;


}
