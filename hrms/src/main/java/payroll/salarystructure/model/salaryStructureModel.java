package payroll.salarystructure.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "salary_structures")
@Getter
@Setter
public class salaryStructureModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryStructure_Id;

    @Column(nullable = false, unique = true)
    private String salaryStructure_Code;

    @Column(nullable = false)
    private String salaryStructure_Name;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal salaryStructure_BasicSalary;

    private Double salaryStructure_HraPercentage = 0.0;

    private Double salaryStructure_PfPercentage = 0.0;

    @Column(nullable = false)
    private Boolean salaryStructure_Active = true;

    private String salaryStructure_Description;
}
