
package payroll.paySlip.model;

import payroll.payRollitem.model.payRollItemModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "payslips",
        uniqueConstraints = @UniqueConstraint(
                columnNames = "payroll_item_id"
        )
)
@Getter
@Setter
public class paySlipModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payslip_Id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payroll_item_id", nullable = false)
    private payRollItemModel payrollItem;

    @Column(nullable = false, unique = true)
    private String payslip_Number;

    private LocalDate payslip_GeneratedDate;

    private LocalDateTime payslip_CreatedAt;

    // GENERATED, PUBLISHED, CANCELLED
    @Column(nullable = false)
    private String payslip_Status = "GENERATED";

    // Generated PDF ka file path ya storage URL
    private String payslip_DocumentUrl;
}
