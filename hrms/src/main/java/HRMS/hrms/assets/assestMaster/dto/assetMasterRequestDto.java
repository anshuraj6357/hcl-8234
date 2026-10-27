package HRMS.hrms.assets.assestMaster.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class assetMasterRequestDto {

    private String assetMaster_Code;

    private String asset_Name;

    private String asset_Category;

    private String asset_Brand;

    private String asset_Model;

    private String asset_Description;

    private String asset_Specifications;

    private Boolean assetMaster_Active = true;
}