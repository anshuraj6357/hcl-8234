
package HRMS.hrms.organisation.department.model;

import HRMS.hrms.organisation.company.model.companyModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class departmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer department_Id;

    @Column(nullable = false)
    private String department_Name;

    @Column(nullable = false, unique = true)
    private String department_Code;

    private String department_Description;

    @Column(nullable = false)
    private Boolean department_Active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private companyModel company;
}
