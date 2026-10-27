package HRMS.hrms.assets.asset.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class assetToResponseDto {

    private Long asset_Id;
    private String asset_Code;
    private Long assetMaster_Id;
    private String asset_SerialNumber;
    private String asset_TagNumber;
    private Long location_Id;
    private LocalDate asset_PurchaseDate;
    private Double asset_PurchaseCost;
    private LocalDate asset_WarrantyExpiryDate;
    private String asset_Status;
    private String asset_Remarks;
    private LocalDateTime asset_CreatedAt;
    private LocalDateTime asset_UpdatedAt;
}