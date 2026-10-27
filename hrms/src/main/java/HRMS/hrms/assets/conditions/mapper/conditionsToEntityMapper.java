package HRMS.hrms.assets.conditions.mapper;

import HRMS.hrms.assets.conditions.dto.conditionsToRequestDto;
import HRMS.hrms.assets.conditions.model.conditionsModel;
import org.springframework.stereotype.Component;

@Component
public class conditionsToEntityMapper {

    public conditionsModel toEntity(conditionsToRequestDto request) {

        conditionsModel condition = new conditionsModel();

        condition.setCondition_Status(request.getCondition_Status());
        condition.setCondition_Remarks(request.getCondition_Remarks());
        condition.setCondition_CheckedAt(request.getCondition_CheckedAt());
        condition.setChecked_By(request.getChecked_By());
        condition.setCondition_DamageDetails(request.getCondition_DamageDetails());

        return condition;
    }
}