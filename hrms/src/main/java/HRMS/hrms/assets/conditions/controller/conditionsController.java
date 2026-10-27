package HRMS.hrms.assets.conditions.controller;

import HRMS.hrms.assets.conditions.dto.conditionsToRequestDto;
import HRMS.hrms.assets.conditions.dto.conditionsToResponseDto;
import HRMS.hrms.assets.conditions.service.conditionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conditions")
public class conditionsController {

    @Autowired
    private conditionsService conditionsService;

    // Create Condition
    @PostMapping
    public ResponseEntity<conditionsToResponseDto> createCondition(
            @RequestBody conditionsToRequestDto condition) {

        conditionsToResponseDto response =
                conditionsService.createCondition(condition);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Get All Conditions
//    @GetMapping
//    public ResponseEntity<List<conditionsToResponseDto>> getAllConditions() {
//
//        List<conditionsToResponseDto> response =
//                conditionsService.getAllConditions();
//
//        return ResponseEntity.ok(response);
//    }

    // Get Condition By ID
    @GetMapping("/{conditionId}")
    public ResponseEntity<conditionsToResponseDto> getConditionById(
            @PathVariable Long conditionId) {

        conditionsToResponseDto response =
                conditionsService.getConditionById(conditionId);

        return ResponseEntity.ok(response);
    }

    // Update Condition
    @PutMapping("/{conditionId}")
    public ResponseEntity<conditionsToResponseDto> updateCondition(
            @PathVariable Long conditionId,
            @RequestBody conditionsToRequestDto condition) {

        conditionsToResponseDto response =
                conditionsService.updateCondition(conditionId, condition);

        return ResponseEntity.ok(response);
    }

    // Delete Condition
    @DeleteMapping("/{conditionId}")
    public ResponseEntity<Void> deleteCondition(
            @PathVariable Long conditionId) {

        conditionsService.deleteCondition(conditionId);

        return ResponseEntity.noContent().build();
    }
}