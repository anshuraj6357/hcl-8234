
package HRMS.hrms.organisation.company.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class companyResponseDto {

    private String company_Name;
    private String company_Code;
    private String company_Address;
    private String company_Email;
    private String company_Phone;

    private Boolean company_Active;

}
