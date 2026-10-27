package HRMS.hrms.assets.assestMaster.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class assetMasterResponseDto {

    private Long assetMaster_Id;

    private String assetMaster_Code;

    private String asset_Name;

    private String asset_Category;

    private String asset_Brand;

    private String asset_Model;

    private String asset_Description;

    private String asset_Specifications;

    private Boolean assetMaster_Active;

    private LocalDateTime assetMaster_CreatedAt;

    private LocalDateTime assetMaster_UpdatedAt;
}