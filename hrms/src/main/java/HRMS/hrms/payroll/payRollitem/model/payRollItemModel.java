
package HRMS.hrms.payroll.payRollitem.model;

import HRMS.hrms.employee.model.employeeModel;
import HRMS.hrms.payroll.payRollRun.model.payrollRunModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(
        name = "payroll_items",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"payroll_run_id", "employee_id"}
        )
)
@Getter
@Setter
public class payRollItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payrollItem_Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payroll_run_id", nullable = false)
    private payrollRunModel payrollRun;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private employeeModel employee;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal payrollItem_GrossSalary;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal payrollItem_TotalEarnings;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal payrollItem_TotalDeductions;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal payrollItem_NetSalary;

    // PENDING, PROCESSED, APPROVED, PAID, FAILED
    @Column(nullable = false)
    private String payrollItem_Status = "PENDING";
}
