package HRMS.hrms.assets.allocation.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class allocationResponseDto {

    private Long allocation_Id;

    private Long asset_Id;

    private Long employee_Id;

    private LocalDate allocation_Date;

    private LocalDate expected_ReturnDate;

    private LocalDate actual_ReturnDate;

    private String allocation_Status;

    private String allocation_Purpose;

    private Long allocated_By;

    private String allocation_Remarks;

    private LocalDateTime allocation_CreatedAt;

    private LocalDateTime allocation_UpdatedAt;
}