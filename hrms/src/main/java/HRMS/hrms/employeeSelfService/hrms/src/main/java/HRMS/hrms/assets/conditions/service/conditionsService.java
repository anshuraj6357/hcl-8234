package HRMS.hrms.assets.conditions.service;

import HRMS.hrms.assets.conditions.dto.conditionsToRequestDto;
import HRMS.hrms.assets.conditions.dto.conditionsToResponseDto;

public interface conditionsService {

    // Create Condition
    conditionsToResponseDto createCondition(
            conditionsToRequestDto condition);

    // Get All Conditions
//    List<conditionsToResponseDto> getAllConditions();

    // Get Condition By ID
    conditionsToResponseDto getConditionById(Long conditionId);

    // Update Condition
    conditionsToResponseDto updateCondition(
            Long conditionId,
            conditionsToRequestDto condition);

    // Delete Condition
    void deleteCondition(Long conditionId);
}