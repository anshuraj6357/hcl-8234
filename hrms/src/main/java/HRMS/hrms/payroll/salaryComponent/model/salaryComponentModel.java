package HRMS.hrms.payroll.salaryComponent.model;

import HRMS.hrms.organisation.branch.model.branchModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import HRMS.hrms.payroll.salaryComponent.enums.salaryComponentType;
import HRMS.hrms.payroll.salaryComponent.enums.salaryComponentCalculationType;

@Entity
@Table(name = "salary_components")
@Getter
@Setter
public class salaryComponentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryComponent_Id;

    @Column(nullable = false, unique = true)
    private String salaryComponent_Code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="branch_id")
    private branchModel branch_Id;

    @Column(nullable = false)
    private String salaryComponent_Name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private salaryComponentType salaryComponent_Type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private salaryComponentCalculationType salaryComponent_CalculationType;

    private Double salaryComponent_Value;

    @Column(nullable = false)
    private Boolean salaryComponent_Active = true;
}