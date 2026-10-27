package HRMS.hrms.assets.assestMaster.service;

import java.util.List;

import HRMS.hrms.assets.assestMaster.dto.assetMasterRequestDto;
import HRMS.hrms.assets.assestMaster.dto.assetMasterResponseDto;

public interface assetMasterService {

    assetMasterResponseDto createAssetMaster(assetMasterRequestDto request);

    List<assetMasterResponseDto> getAllAssetMasters();

    assetMasterResponseDto getAssetMasterById(Long assetMaster_Id);

    assetMasterResponseDto updateAssetMaster(
            Long assetMaster_Id,
            assetMasterRequestDto request
    );

    void deleteAssetMaster(Long assetMaster_Id);
}