package HRMS.hrms.assets.maintenance.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class maintenanceToResponseDto {

    private Long maintenance_Id;

    private Long asset_Id;

    private String maintenance_Type;

    private LocalDate maintenance_Date;

    private LocalDate maintenance_CompletionDate;

    private String maintenance_Vendor;

    private Double maintenance_Cost;

    private String maintenance_Status;

    private String maintenance_Description;

    private String maintenance_Remarks;

    private LocalDate next_MaintenanceDate;

    private Long created_By;

    private LocalDateTime maintenance_CreatedAt;

    private LocalDateTime maintenance_UpdatedAt;
}