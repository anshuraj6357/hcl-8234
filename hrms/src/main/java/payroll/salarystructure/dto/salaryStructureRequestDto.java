
package payroll.salarystructure.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class salaryStructureRequestDto {

    private Long salaryStructure_Id;

    private String salaryStructure_Code;

    private String salaryStructure_Name;

    private BigDecimal salaryStructure_BasicSalary;

    private Double salaryStructure_HraPercentage;

    private Double salaryStructure_PfPercentage;

    private Boolean salaryStructure_Active;

    private Long branch_Id;

    private Long employee_Id;

    private String salaryStructure_Description;
}
