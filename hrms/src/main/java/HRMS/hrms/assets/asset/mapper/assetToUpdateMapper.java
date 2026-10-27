package HRMS.hrms.assets.asset.mapper;

import org.springframework.stereotype.Component;

import HRMS.hrms.assets.asset.dto.assetToRequestDto;
import HRMS.hrms.assets.asset.model.assetModel;

@Component
public class assetToUpdateMapper {

    public assetModel toUpdateEntity(
            assetModel asset,
            assetToRequestDto request) {

        asset.setAsset_Code(request.getAsset_Code());
        asset.setAsset_SerialNumber(request.getAsset_SerialNumber());
        asset.setAsset_TagNumber(request.getAsset_TagNumber());
        asset.setAsset_PurchaseDate(request.getAsset_PurchaseDate());
        asset.setAsset_PurchaseCost(request.getAsset_PurchaseCost());
        asset.setAsset_WarrantyExpiryDate(
                request.getAsset_WarrantyExpiryDate());

        if (request.getAsset_Status() != null) {
            asset.setAsset_Status(request.getAsset_Status());
        }

        asset.setAsset_Remarks(request.getAsset_Remarks());

        return asset;
    }
}