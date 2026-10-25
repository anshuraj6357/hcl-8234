
package HRMS.hrms.organisation.department.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class departmentRequestDto {

    private String department_Name;

    private String department_Code;

    private String department_Description;

    private Boolean department_Active;

    private Long companyId;
}
