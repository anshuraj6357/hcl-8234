package HRMS.hrms.assets.conditions.service;

import HRMS.hrms.assets.conditions.dto.conditionsToRequestDto;
import HRMS.hrms.assets.conditions.dto.conditionsToResponseDto;
import HRMS.hrms.assets.conditions.mapper.conditionsToDtoMapper;
import HRMS.hrms.assets.conditions.mapper.conditionsToEntityMapper;
import HRMS.hrms.assets.conditions.mapper.conditionsToUpdateMapper;
import HRMS.hrms.assets.conditions.model.conditionsModel;
import HRMS.hrms.assets.conditions.repository.conditionsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class conditionsServiceImpl implements conditionsService {

    @Autowired
    private conditionsRepository conditionsRepository;

    @Autowired
    private conditionsToEntityMapper conditionsToEntityMapper;

    @Autowired
    private conditionsToDtoMapper conditionsToDtoMapper;

    @Autowired
    private conditionsToUpdateMapper conditionsToUpdateMapper;

    // Create Condition
    @Override
    public conditionsToResponseDto createCondition(
            conditionsToRequestDto condition) {

        conditionsModel conditionModel =
                conditionsToEntityMapper.toEntity(condition);

        conditionsModel savedCondition =
                conditionsRepository.save(conditionModel);

        return conditionsToDtoMapper.toDto(savedCondition);
    }

    // Get All Conditions
//    @Override
//    public List<conditionsToResponseDto> getAllConditions() {
//
//        return conditionsRepository.findAll()
//                .stream()
//                .map(conditionsToDtoMapper::toDto)
//                .collect(Collectors.toList());
//    }

    // Get Condition By ID
    @Override
    public conditionsToResponseDto getConditionById(Long conditionId) {

        conditionsModel condition =
                conditionsRepository.findById(conditionId)
                        .orElseThrow(() -> new RuntimeException(
                                "Condition not found with ID: " + conditionId));

        return conditionsToDtoMapper.toDto(condition);
    }

    // Update Condition
    @Override
    public conditionsToResponseDto updateCondition(
            Long conditionId,
            conditionsToRequestDto condition) {

        conditionsModel existingCondition =
                conditionsRepository.findById(conditionId)
                        .orElseThrow(() -> new RuntimeException(
                                "Condition not found with ID: " + conditionId));

        conditionsModel updatedCondition =
                conditionsToUpdateMapper.toUpdateEntity(
                        existingCondition, condition);

        conditionsModel savedCondition =
                conditionsRepository.save(updatedCondition);

        return conditionsToDtoMapper.toDto(savedCondition);
    }

    // Delete Condition
    @Override
    public void deleteCondition(Long conditionId) {

        conditionsModel condition =
                conditionsRepository.findById(conditionId)
                        .orElseThrow(() -> new RuntimeException(
                                "Condition not found with ID: " + conditionId));

        conditionsRepository.delete(condition);
    }
}