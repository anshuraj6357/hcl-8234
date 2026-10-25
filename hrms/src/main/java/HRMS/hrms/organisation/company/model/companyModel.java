
package HRMS.hrms.organisation.company.model;

import jakarta.persistence.*;
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

    private String company_Address;

    private String company_Email;

    private String company_Phone;

    @Column(nullable = false)
    private Boolean company_Active = true;

}
