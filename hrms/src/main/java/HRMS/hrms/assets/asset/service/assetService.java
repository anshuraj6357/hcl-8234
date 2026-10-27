package HRMS.hrms.assets.asset.service;

import java.util.List;

import HRMS.hrms.assets.asset.dto.assetToRequestDto;
import HRMS.hrms.assets.asset.dto.assetToResponseDto;

public interface assetService {

    assetToResponseDto createAsset(assetToRequestDto request);

    List<assetToResponseDto> getAllAssets();

    assetToResponseDto getAssetById(Long asset_Id);

    assetToResponseDto updateAsset(
            Long asset_Id,
            assetToRequestDto request);

    void deleteAsset(Long asset_Id);
}