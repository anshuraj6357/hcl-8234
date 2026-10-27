
package HRMS.hrms.organisation.designation.mapper;

import HRMS.hrms.organisation.designation.dto.designationRequestDto;
import HRMS.hrms.organisation.designation.model.designationModel;
import HRMS.hrms.organisation.department.model.departmentModel;
import org.springframework.stereotype.Component;

@Component
public class designationtoEntityMapper {

    public designationModel toEntity(
            designationRequestDto dto,
            departmentModel department) {

        designationModel designation = new designationModel();

        designation.setDesignation_Name(dto.getDesignation_Name());
        designation.setDesignation_Code(dto.getDesignation_Code());
        designation.setDesignation_Description(
                dto.getDesignation_Description()
        );

        if (dto.getDesignation_Active() != null) {
            designation.setDesignation_Active(dto.getDesignation_Active());
        } else {
            designation.setDesignation_Active(true);
        }

        designation.setDepartment(department);

        return designation;
    }
    }

