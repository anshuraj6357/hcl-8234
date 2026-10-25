
package HRMS.hrms.organisation.designation.mapper;

import HRMS.hrms.organisation.designation.dto.designationRequestDto;
import HRMS.hrms.organisation.designation.model.designationModel;
import org.springframework.stereotype.Component;

@Component
public class designatoinToUpdateMapper {

    public designationModel toUpdate(
            designationRequestDto dto,
            designationModel existingDesignation) {

        if (dto.getDesignation_Name() != null) {
            existingDesignation.setDesignation_Name(
                    dto.getDesignation_Name()
            );
        }

        if (dto.getDesignation_Code() != null) {
            existingDesignation.setDesignation_Code(
                    dto.getDesignation_Code()
            );
        }

        if (dto.getDesignation_Description() != null) {
            existingDesignation.setDesignation_Description(
                    dto.getDesignation_Description()
            );
        }

        if (dto.getDesignation_Active() != null) {
            existingDesignation.setDesignation_Active(
                    dto.getDesignation_Active()
            );
        }

        return existingDesignation;
    }
}
