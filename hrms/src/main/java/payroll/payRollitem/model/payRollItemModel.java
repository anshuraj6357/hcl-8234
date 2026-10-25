
package payroll.payRollitem.model;

import payroll.payRollRun.model.payrollRunModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(
        name = "payroll_items",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"payroll_run_id", "employeeId"}
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

    @Column(nullable = false)
    private Long employeeId;

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
