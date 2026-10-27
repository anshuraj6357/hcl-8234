package HRMS.hrms.assets.maintenance.mapper;

import HRMS.hrms.assets.maintenance.dto.maintenanceToResponseDto;
import HRMS.hrms.assets.maintenance.model.maintenanceModel;
import org.springframework.stereotype.Component;

@Component
public class maintenanceToDtoMapper {

    public maintenanceToResponseDto toDto(maintenanceModel maintenance) {

        maintenanceToResponseDto response = new maintenanceToResponseDto();

        response.setMaintenance_Id(maintenance.getMaintenance_Id());

        response.setMaintenance_Type(maintenance.getMaintenance_Type());
        response.setMaintenance_Date(maintenance.getMaintenance_Date());

        response.setMaintenance_CompletionDate(
                maintenance.getMaintenance_CompletionDate());

        response.setMaintenance_Vendor(maintenance.getMaintenance_Vendor());
        response.setMaintenance_Cost(maintenance.getMaintenance_Cost());
        response.setMaintenance_Status(maintenance.getMaintenance_Status());

        response.setMaintenance_Description(
                maintenance.getMaintenance_Description());

        response.setMaintenance_Remarks(maintenance.getMaintenance_Remarks());

        response.setNext_MaintenanceDate(
                maintenance.getNext_MaintenanceDate());

        response.setCreated_By(maintenance.getCreated_By());

        response.setMaintenance_CreatedAt(
                maintenance.getMaintenance_CreatedAt());

        response.setMaintenance_UpdatedAt(
                maintenance.getMaintenance_UpdatedAt());

        return response;
    }
}