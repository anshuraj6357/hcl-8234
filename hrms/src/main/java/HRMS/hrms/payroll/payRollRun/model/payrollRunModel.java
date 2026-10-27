package HRMS.hrms.payroll.payRollRun.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "payroll_runs",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"payrollRun_Month", "payrollRun_Year"}
        )
)
@Getter
@Setter
public class payrollRunModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payrollRun_Id;

    @Column(nullable = false)
    private Integer payrollRun_Month;

    @Column(nullable = false)
    private Integer payrollRun_Year;

    private LocalDate payrollRun_PeriodStart;

    private LocalDate payrollRun_PeriodEnd;

    // DRAFT, PROCESSING, COMPLETED, FAILED
    @Column(nullable = false)
    private String payrollRun_Status = "DRAFT";

    private LocalDateTime payrollRun_StartedAt;

    private LocalDateTime payrollRun_CompletedAt;

    private LocalDate payrollRun_PaymentDate;

    private String payrollRun_Notes;
}
