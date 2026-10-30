package HRMS.hrms.assets.asset.service;

import java.util.List;

import HRMS.hrms.organisation.location.Repository.locationRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HRMS.hrms.assets.asset.dto.assetToRequestDto;
import HRMS.hrms.assets.asset.dto.assetToResponseDto;
import HRMS.hrms.assets.asset.mapper.assetToDtoMapper;
import HRMS.hrms.assets.asset.mapper.assetToEntityMapper;
import HRMS.hrms.assets.asset.mapper.assetToUpdateMapper;
import HRMS.hrms.assets.asset.model.assetModel;
import HRMS.hrms.assets.asset.repository.assetRepository;

import HRMS.hrms.assets.assestMaster.model.assestMasterModel;
import HRMS.hrms.assets.assestMaster.repository.assetMasterRepository;

import HRMS.hrms.organisation.location.model.locationModel;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class assetServiceImpl implements assetService {

    private final assetRepository assetRepository;
    private final assetMasterRepository assetMasterRepository;
    private final locationRepo locationRepository;
    private final assetToEntityMapper assetToEntityMapper;
    private final assetToDtoMapper assetToDtoMapper;
    private final assetToUpdateMapper assetToUpdateMapper;

    public assetServiceImpl(
            assetRepository assetRepository,
            assetMasterRepository assetMasterRepository,
            locationRepo locationRepository,
            assetToEntityMapper assetToEntityMapper,
            assetToDtoMapper assetToDtoMapper,
            assetToUpdateMapper assetToUpdateMapper) {
        this.assetRepository = assetRepository;
        this.assetMasterRepository = assetMasterRepository;
        this.locationRepository = locationRepository;
        this.assetToEntityMapper = assetToEntityMapper;
        this.assetToDtoMapper = assetToDtoMapper;
        this.assetToUpdateMapper = assetToUpdateMapper;
    }

    @Override
    public assetToResponseDto createAsset(assetToRequestDto request) {

        if (assetRepository.existsByAssetCode(request.getAsset_Code())) {
            throw new IllegalArgumentException("Asset code already exists");
        }

        if (request.getAsset_SerialNumber() != null
                && assetRepository.existsByAssetSerialNumber(
                request.getAsset_SerialNumber())) {
            throw new IllegalArgumentException(
                    "Asset serial number already exists");
        }

        assetModel asset = assetToEntityMapper.toEntity(request);

        assestMasterModel master = assetMasterRepository
                .findById(request.getAssetMaster_Id())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Asset master not found: "
                                + request.getAssetMaster_Id()));

        asset.setAssetMaster_Id(master);

        if (request.getLocation_Id() != null) {
            locationModel location = locationRepository
                    .findById(request.getLocation_Id())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Location not found: "
                                    + request.getLocation_Id()));

            asset.setLocation_Id(location);
        }

        return assetToDtoMapper.toDto(assetRepository.save(asset));
    }

    @Override
    @Transactional(readOnly = true)
    public List<assetToResponseDto> getAllAssets() {

        return assetRepository.findAll()
                .stream()
                .map(assetToDtoMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public assetToResponseDto getAssetById(Long asset_Id) {

        assetModel asset = assetRepository.findById(asset_Id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Asset not found: " + asset_Id));

        return assetToDtoMapper.toDto(asset);
    }

    @Override
    public assetToResponseDto updateAsset(
            Long asset_Id,
            assetToRequestDto request) {

        assetModel asset = assetRepository.findById(asset_Id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Asset not found: " + asset_Id));

        if (request.getAsset_Code() != null
                && !request.getAsset_Code().equals(asset.getAsset_Code())
                && assetRepository.existsByAssetCode(request.getAsset_Code())) {
            throw new IllegalArgumentException("Asset code already exists");
        }


        if (request.getAsset_SerialNumber() != null
                && !request.getAsset_SerialNumber()
                .equals(asset.getAsset_SerialNumber())
                && assetRepository.existsByAssetSerialNumber(
                request.getAsset_SerialNumber())) {
            throw new IllegalArgumentException(
                    "Asset serial number already exists");
        }

        if (request.getAssetMaster_Id() != null) {
            assestMasterModel master = assetMasterRepository
                    .findById(request.getAssetMaster_Id())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Asset master not found: "
                                    + request.getAssetMaster_Id()));

            asset.setAssetMaster_Id(master);
        }

        if (request.getLocation_Id() != null) {
            locationModel location = locationRepository
                    .findById(request.getLocation_Id())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Location not found: "
                                    + request.getLocation_Id()));

            asset.setLocation_Id(location);
        }

        assetToUpdateMapper.toUpdateEntity(asset, request);

        return assetToDtoMapper.toDto(assetRepository.save(asset));
    }

    @Override
    public void deleteAsset(Long asset_Id) {

        assetModel asset = assetRepository.findById(asset_Id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Asset not found: " + asset_Id));

        assetRepository.delete(asset);
    }
}