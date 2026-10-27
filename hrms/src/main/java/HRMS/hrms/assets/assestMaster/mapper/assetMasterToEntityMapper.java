package HRMS.hrms.assets.assestMaster.mapper;


import HRMS.hrms.assets.assestMaster.dto.assetMasterRequestDto;
import HRMS.hrms.assets.assestMaster.model.assestMasterModel;
import org.springframework.stereotype.Component;



@Component
public class assetMasterToEntityMapper {
    public assestMasterModel toEntity(assetMasterRequestDto request) {

        assestMasterModel asset = new assestMasterModel();

        asset.setAssetMaster_Code(request.getAssetMaster_Code());
        asset.setAsset_Name(request.getAsset_Name());
        asset.setAsset_Category(request.getAsset_Category());
        asset.setAsset_Brand(request.getAsset_Brand());
        asset.setAsset_Model(request.getAsset_Model());
        asset.setAsset_Description(request.getAsset_Description());
        asset.setAsset_Specifications(request.getAsset_Specifications());

        if (request.getAssetMaster_Active() != null) {
            asset.setAssetMaster_Active(request.getAssetMaster_Active());
        }

        return asset;
    }
}
