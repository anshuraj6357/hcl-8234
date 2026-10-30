
package HRMS.hrms.organisation.company.dto;

import HRMS.hrms.organisation.location.model.locationModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class companyResponseDto {

    private Long company_Id;
    private String company_Name;
    private String company_Code;
    private locationModel location_id;
    private String company_Email;
    private String company_Phone;

    private Boolean company_Active;

}
