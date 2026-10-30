
package HRMS.hrms.organisation.company.model;

import HRMS.hrms.organisation.location.model.locationModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class companyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long company_Id;

    @Column(nullable = false)
    private String company_Name;

    @Column(nullable = false, unique = true)
    private String company_Code;


    @OneToOne(mappedBy = "company_Id", cascade = CascadeType.ALL)
    private locationModel location_id;

    private String company_Email;

    private String company_Phone;

    @Column(nullable = false)
    private Boolean company_Active = true;

    @Column(nullable = false)
    private Boolean company_Verified = false;
}
