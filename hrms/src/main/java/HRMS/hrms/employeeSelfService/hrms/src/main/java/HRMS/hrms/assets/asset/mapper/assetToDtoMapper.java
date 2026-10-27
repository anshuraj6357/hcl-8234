package HRMS.hrms.assets.asset.mapper;

import org.springframework.stereotype.Component;

import HRMS.hrms.assets.asset.dto.assetToResponseDto;
import HRMS.hrms.assets.asset.model.assetModel;

@Component
public class assetToDtoMapper {

    public assetToResponseDto toDto(assetModel asset) {

        assetToResponseDto response = new assetToResponseDto();

        response.setAsset_Id(asset.getAsset_Id());
        response.setAsset_Code(asset.getAsset_Code());

        if (asset.getAssetMaster_Id() != null) {
            response.setAssetMaster_Id(
                    asset.getAssetMaster_Id().getAssetMaster_Id());
        }

        response.setAsset_SerialNumber(asset.getAsset_SerialNumber());
        response.setAsset_TagNumber(asset.getAsset_TagNumber());

        if (asset.getLocation_Id() != null) {
            response.setLocation_Id(
                    asset.getLocation_Id().getLocation_Id());
        }

        response.setAsset_PurchaseDate(asset.getAsset_PurchaseDate());
        response.setAsset_PurchaseCost(asset.getAsset_PurchaseCost());
        response.setAsset_WarrantyExpiryDate(
                asset.getAsset_WarrantyExpiryDate());
        response.setAsset_Status(asset.getAsset_Status());
        response.setAsset_Remarks(asset.getAsset_Remarks());
        response.setAsset_CreatedAt(asset.getAsset_CreatedAt());
        response.setAsset_UpdatedAt(asset.getAsset_UpdatedAt());

        return response;
    }
}