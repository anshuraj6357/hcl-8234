package payroll.employeeSalary.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;



@Getter
@Setter

public class employeeSalaryResponseDto {


    private Long employeeSalary_Id;
    private Long employeeId;
    private Long salaryStructureId;

    private BigDecimal employeeSalary_GrossSalary;

    private LocalDate employeeSalary_EffectiveFrom;

    private LocalDate employeeSalary_EffectiveTo;

    private Boolean employeeSalary_Active = true;
}
