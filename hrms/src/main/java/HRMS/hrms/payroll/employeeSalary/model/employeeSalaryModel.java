
package HRMS.hrms.payroll.employeeSalary.model;

import HRMS.hrms.employee.model.employeeModel;
import HRMS.hrms.payroll.salarystructure.model.salaryStructureModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private employeeModel employee;

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
