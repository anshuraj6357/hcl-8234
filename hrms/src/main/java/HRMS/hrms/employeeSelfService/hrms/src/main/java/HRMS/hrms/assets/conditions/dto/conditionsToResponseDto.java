package HRMS.hrms.assets.conditions.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class conditionsToResponseDto {

    private Long condition_Id;

    private Long asset_Id;

    private String condition_Status;

    private String condition_Remarks;

    private LocalDateTime condition_CheckedAt;

    private Long checked_By;

    private String condition_DamageDetails;
}