
package payroll.payrollComponent.model;

import payroll.payRollitem.model.payRollItemModel;
import payroll.salaryComponent.model.salaryComponentModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "payroll_components")
@Getter
@Setter
public class payrollComponentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payrollComponent_Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payroll_item_id", nullable = false)
    private payRollItemModel payrollItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_component_id", nullable = false)
    private salaryComponentModel salaryComponent;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal payrollComponent_Amount;

    // EARNING or DEDUCTION
    @Column(nullable = false)
    private String payrollComponent_Type;
}
