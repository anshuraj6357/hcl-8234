
package HRMS.hrms.organisation.designation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class designationResponseDto {

    private Long designation_Id;

    private String designation_Name;

    private String designation_Code;

    private String designation_Description;

    private Boolean designation_Active;

    private Long departmentId;
}
