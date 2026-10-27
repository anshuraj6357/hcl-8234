package HRMS.hrms.assets.maintenance.service;

import HRMS.hrms.assets.maintenance.dto.maintenanceToRequestDto;
import HRMS.hrms.assets.maintenance.dto.maintenanceToResponseDto;

public interface maintenanceservice {

    maintenanceToResponseDto createMaintenance(maintenanceToRequestDto maintenance);

//    List<maintenanceToResponseDto> getAllMaintenance();

    maintenanceToResponseDto getMaintenanceById(Long maintenanceId);

    maintenanceToResponseDto updateMaintenance(
            Long maintenanceId,
            maintenanceToRequestDto maintenance);

    void deleteMaintenance(Long maintenanceId);
}