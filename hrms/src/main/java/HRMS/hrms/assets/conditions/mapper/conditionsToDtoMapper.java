package HRMS.hrms.assets.conditions.mapper;

import HRMS.hrms.assets.conditions.dto.conditionsToResponseDto;
import HRMS.hrms.assets.conditions.model.conditionsModel;
import org.springframework.stereotype.Component;

@Component
public class conditionsToDtoMapper {

    public conditionsToResponseDto toDto(conditionsModel condition) {

        conditionsToResponseDto response = new conditionsToResponseDto();

        response.setCondition_Id(condition.getCondition_Id());

        if (condition.getAsset_Id() != null) {
            response.setAsset_Id(condition.getAsset_Id().getAsset_Id());
        }

        response.setCondition_Status(condition.getCondition_Status());
        response.setCondition_Remarks(condition.getCondition_Remarks());
        response.setCondition_CheckedAt(condition.getCondition_CheckedAt());
        response.setChecked_By(condition.getChecked_By());
        response.setCondition_DamageDetails(condition.getCondition_DamageDetails());

        return response;
    }
}