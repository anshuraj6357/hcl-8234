package HRMS.hrms.assets.maintenance.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class maintenanceToRequestDto {

    private Long asset_Id;

    private String maintenance_Type;

    private LocalDate maintenance_Date;

    private LocalDate maintenance_CompletionDate;

    private String maintenance_Vendor;

    private Double maintenance_Cost;

    private String maintenance_Status = "PENDING";

    private String maintenance_Description;

    private String maintenance_Remarks;

    private LocalDate next_MaintenanceDate;

    private Long created_By;
}