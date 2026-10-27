package HRMS.hrms.assets.asset.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class assetToRequestDto {

    private String asset_Code;
    private Long assetMaster_Id;
    private String asset_SerialNumber;
    private String asset_TagNumber;
    private Long location_Id;
    private LocalDate asset_PurchaseDate;
    private Double asset_PurchaseCost;
    private LocalDate asset_WarrantyExpiryDate;
    private String asset_Status = "AVAILABLE";
    private String asset_Remarks;
}