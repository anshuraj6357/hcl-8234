package HRMS.hrms.assets.assestMaster.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import HRMS.hrms.assets.assestMaster.dto.assetMasterRequestDto;
import HRMS.hrms.assets.assestMaster.dto.assetMasterResponseDto;
import HRMS.hrms.assets.assestMaster.mapper.assetMasterToDtoMapper;
import HRMS.hrms.assets.assestMaster.mapper.assetMasterToEntityMapper;
import HRMS.hrms.assets.assestMaster.mapper.assetMasterToUpdateMapper;
import HRMS.hrms.assets.assestMaster.model.assestMasterModel;
import HRMS.hrms.assets.assestMaster.repository.assetMasterRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class assetMasterServiceImp implements assetMasterService {

    private final assetMasterRepository assetMasterRepository;
    private final assetMasterToEntityMapper assetMasterToEntityMapper;
    private final assetMasterToDtoMapper assetMasterToDtoMapper;
    private final assetMasterToUpdateMapper assetMasterToUpdateMapper;

    @Override
    public assetMasterResponseDto createAssetMaster(
            assetMasterRequestDto request) {

        if (assetMasterRepository.existsByAssetMaster_Code(
                request.getAssetMaster_Code())) {
            throw new IllegalArgumentException(
                    "Asset master code already exists");
        }

        assestMasterModel asset =
                assetMasterToEntityMapper.toEntity(request);

        assestMasterModel savedAsset =
                assetMasterRepository.save(asset);

        return assetMasterToDtoMapper.toDto(savedAsset);
    }

    @Override
    public List<assetMasterResponseDto> getAllAssetMasters() {

        return assetMasterRepository.findAll()
                .stream()
                .map(assetMasterToDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public assetMasterResponseDto getAssetMasterById(
            Long assetMaster_Id) {

        assestMasterModel asset = assetMasterRepository
                .findById(assetMaster_Id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Asset master not found with ID: " + assetMaster_Id));

        return assetMasterToDtoMapper.toDto(asset);
    }

    @Override
    public assetMasterResponseDto updateAssetMaster(
            Long assetMaster_Id,
            assetMasterRequestDto request) {

        assestMasterModel existingAsset = assetMasterRepository
                .findById(assetMaster_Id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Asset master not found with ID: " + assetMaster_Id));

        String requestedCode = request.getAssetMaster_Code();

        if (requestedCode != null
                && !requestedCode.equals(existingAsset.getAssetMaster_Code())
                && assetMasterRepository.existsByAssetMaster_Code(requestedCode)) {
            throw new IllegalArgumentException(
                    "Asset master code already exists");
        }

        assetMasterToUpdateMapper.toUpdateEntity(existingAsset, request);

        assestMasterModel updatedAsset =
                assetMasterRepository.save(existingAsset);

        return assetMasterToDtoMapper.toDto(updatedAsset);
    }

    @Override
    public void deleteAssetMaster(Long assetMaster_Id) {

        assestMasterModel asset = assetMasterRepository
                .findById(assetMaster_Id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Asset master not found with ID: " + assetMaster_Id));

        assetMasterRepository.delete(asset);
    }
}