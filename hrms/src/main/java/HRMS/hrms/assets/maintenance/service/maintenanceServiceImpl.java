package HRMS.hrms.assets.maintenance.service;

import HRMS.hrms.assets.maintenance.dto.maintenanceToRequestDto;
import HRMS.hrms.assets.maintenance.dto.maintenanceToResponseDto;
import HRMS.hrms.assets.maintenance.mapper.maintenanceToDtoMapper;
import HRMS.hrms.assets.maintenance.mapper.maintenanceToEntityMapper;
import HRMS.hrms.assets.maintenance.mapper.maintenanceToUpdateMapper;
import HRMS.hrms.assets.maintenance.model.maintenanceModel;
import HRMS.hrms.assets.maintenance.repository.maintenanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class maintenanceServiceImpl implements maintenanceservice {

    @Autowired
    private maintenanceRepository maintenanceRepository;

    @Autowired
    private maintenanceToEntityMapper maintenanceToEntityMapper;

    @Autowired
    private maintenanceToDtoMapper maintenanceToDtoMapper;

    @Autowired
    private maintenanceToUpdateMapper maintenanceToUpdateMapper;

    // Create Maintenance
    @Override
    public maintenanceToResponseDto createMaintenance(
            maintenanceToRequestDto maintenance) {

        maintenanceModel maintenanceModel =
                maintenanceToEntityMapper.toEntity(maintenance);

        maintenanceModel savedMaintenance =
                maintenanceRepository.save(maintenanceModel);

        return maintenanceToDtoMapper.toDto(savedMaintenance);
    }

    // Get All Maintenance
//    @Override
//    public List<maintenanceToResponseDto> getAllMaintenance() {
//
//        return maintenanceRepository.findAll()
//                .stream()
//                .map(maintenanceToDtoMapper::toDto)
//                .collect(Collectors.toList());
//    }

    // Get Maintenance By ID
    @Override
    public maintenanceToResponseDto getMaintenanceById(Long maintenanceId) {

        maintenanceModel maintenance =
                maintenanceRepository.findById(maintenanceId)
                        .orElseThrow(() -> new RuntimeException(
                                "Maintenance not found with ID: " + maintenanceId));

        return maintenanceToDtoMapper.toDto(maintenance);
    }

    // Update Maintenance
    @Override
    public maintenanceToResponseDto updateMaintenance(
            Long maintenanceId,
            maintenanceToRequestDto maintenance) {

        maintenanceModel existingMaintenance =
                maintenanceRepository.findById(maintenanceId)
                        .orElseThrow(() -> new RuntimeException(
                                "Maintenance not found with ID: " + maintenanceId));

        maintenanceModel updatedMaintenance =
                maintenanceToUpdateMapper.toUpdateEntity(
                        existingMaintenance, maintenance);

        maintenanceModel savedMaintenance =
                maintenanceRepository.save(updatedMaintenance);

        return maintenanceToDtoMapper.toDto(savedMaintenance);
    }

    // Delete Maintenance
    @Override
    public void deleteMaintenance(Long maintenanceId) {

        maintenanceModel maintenance =
                maintenanceRepository.findById(maintenanceId)
                        .orElseThrow(() -> new RuntimeException(
                                "Maintenance not found with ID: " + maintenanceId));

        maintenanceRepository.delete(maintenance);
    }
}