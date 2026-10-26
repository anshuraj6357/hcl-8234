
package HRMS.hrms.organisation.branch.model;

import HRMS.hrms.organisation.company.model.companyModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "branches",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_company_branch_code",
                        columnNames = {"company_id", "branch_code"}
                )
        }
)
@Getter
@Setter

public class branchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branch_Id;

    @Column(name = "branch_code", nullable = false)
    private String branch_Code;

    @Column(name = "branch_name", nullable = false)
    private String branch_Name;

    @Column(name = "branch_address")
    private String branch_Address;

    @Column(name = "branch_city")
    private String branch_City;

    @Column(name = "branch_state")
    private String branch_State;

    @Column(name = "branch_pincode")
    private String branch_Pincode;

    @Column(name = "branch_active", nullable = false)
    private Boolean branch_Active = true;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private companyModel company_Id;
}
