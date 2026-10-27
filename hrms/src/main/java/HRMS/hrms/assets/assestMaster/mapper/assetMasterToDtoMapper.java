package HRMS.hrms.assets.assestMaster.mapper;

import HRMS.hrms.assets.assestMaster.dto.assetMasterResponseDto;
import HRMS.hrms.assets.assestMaster.model.assestMasterModel;
import org.springframework.stereotype.Component;

@Component
public class assetMasterToDtoMapper {

    public assetMasterResponseDto toDto(assestMasterModel asset) {

        assetMasterResponseDto response =
                new assetMasterResponseDto();

        response.setAssetMaster_Id(asset.getAssetMaster_Id());
        response.setAssetMaster_Code(asset.getAssetMaster_Code());
        response.setAsset_Name(asset.getAsset_Name());
        response.setAsset_Category(asset.getAsset_Category());
        response.setAsset_Brand(asset.getAsset_Brand());
        response.setAsset_Model(asset.getAsset_Model());
        response.setAsset_Description(asset.getAsset_Description());
        response.setAsset_Specifications(asset.getAsset_Specifications());
        response.setAssetMaster_Active(asset.getAssetMaster_Active());
        response.setAssetMaster_CreatedAt(asset.getAssetMaster_CreatedAt());
        response.setAssetMaster_UpdatedAt(asset.getAssetMaster_UpdatedAt());

        return response;
    }
}