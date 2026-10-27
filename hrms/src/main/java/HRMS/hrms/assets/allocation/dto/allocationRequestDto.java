package HRMS.hrms.assets.allocation.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class allocationRequestDto {

    private Long asset_Id;

    private Long employee_Id;

    private LocalDate allocation_Date;

    private LocalDate expected_ReturnDate;

    private LocalDate actual_ReturnDate;

    private String allocation_Status = "ALLOCATED";

    private String allocation_Purpose;

    private Long allocated_By;

    private String allocation_Remarks;
}