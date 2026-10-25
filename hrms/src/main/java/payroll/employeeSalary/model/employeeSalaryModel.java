
package payroll.employeeSalary.model;

import payroll.salarystructure.model.salaryStructureModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employee_salaries")
@Getter
@Setter
public class employeeSalaryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeSalary_Id;

    // Existing employeeModel se baad mein relation add kar sakte hain
    @Column(nullable = false)
    private Long employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_structure_id", nullable = false)
    private salaryStructureModel salaryStructure;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal employeeSalary_GrossSalary;

    @Column(nullable = false)
    private LocalDate employeeSalary_EffectiveFrom;

    private LocalDate employeeSalary_EffectiveTo;

    @Column(nullable = false)
    private Boolean employeeSalary_Active = true;
}
