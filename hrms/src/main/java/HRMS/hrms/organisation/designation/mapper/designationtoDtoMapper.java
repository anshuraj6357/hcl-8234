
package HRMS.hrms.organisation.designation.mapper;

import HRMS.hrms.organisation.designation.dto.designationResponseDto;
import HRMS.hrms.organisation.designation.model.designationModel;
import org.springframework.stereotype.Component;

@Component
public class designationtoDtoMapper {

    public designationResponseDto toDto(designationModel designation) {

        designationResponseDto response = new designationResponseDto();

        response.setDesignation_Id(designation.getDesignation_Id());
        response.setDesignation_Name(designation.getDesignation_Name());
        response.setDesignation_Code(designation.getDesignation_Code());
        response.setDesignation_Description(
                designation.getDesignation_Description()
        );
        response.setDesignation_Active(designation.getDesignation_Active());

//        if (designation.getDepartment() != null) {
//           response.setDepartmentId(designation.getDepartment().getDepartment_Id().longValue());
//        }

        return response;
    }
}
