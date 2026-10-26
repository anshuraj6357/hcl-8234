package payroll.salaryComponent.dto;

import lombok.Getter;
import lombok.Setter;
import payroll.salaryComponent.enums.salaryComponentCalculationType;
import payroll.salaryComponent.enums.salaryComponentType;

import java.math.BigDecimal;



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
