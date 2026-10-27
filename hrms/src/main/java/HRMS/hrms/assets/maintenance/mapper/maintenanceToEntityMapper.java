package HRMS.hrms.assets.maintenance.mapper;

import HRMS.hrms.assets.maintenance.dto.maintenanceToRequestDto;
import HRMS.hrms.assets.maintenance.model.maintenanceModel;
import org.springframework.stereotype.Component;

@Component
public class maintenanceToEntityMapper {

    public maintenanceModel toEntity(maintenanceToRequestDto request) {

        maintenanceModel maintenance = new maintenanceModel();

        maintenance.setMaintenance_Type(request.getMaintenance_Type());
        maintenance.setMaintenance_Date(request.getMaintenance_Date());
        maintenance.setMaintenance_CompletionDate(
                request.getMaintenance_CompletionDate());
        maintenance.setMaintenance_Vendor(request.getMaintenance_Vendor());
        maintenance.setMaintenance_Cost(request.getMaintenance_Cost());
        maintenance.setMaintenance_Status(request.getMaintenance_Status());
        maintenance.setMaintenance_Description(
                request.getMaintenance_Description());
        maintenance.setMaintenance_Remarks(request.getMaintenance_Remarks());
        maintenance.setNext_MaintenanceDate(
                request.getNext_MaintenanceDate());
        maintenance.setCreated_By(request.getCreated_By());

        return maintenance;
    }
}