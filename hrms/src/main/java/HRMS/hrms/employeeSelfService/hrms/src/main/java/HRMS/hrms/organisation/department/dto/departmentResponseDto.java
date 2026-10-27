
package HRMS.hrms.organisation.department.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class departmentResponseDto {



    private String department_Name;

    private String department_Code;

    private String department_Description;

    private Boolean department_Active;
    @ManyToOne(fetch = FetchType.LAZY)
    private Long companyId;
}
