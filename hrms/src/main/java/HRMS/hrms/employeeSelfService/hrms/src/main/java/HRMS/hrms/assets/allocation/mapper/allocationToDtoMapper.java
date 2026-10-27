package HRMS.hrms.assets.allocation.mapper;

import HRMS.hrms.assets.allocation.dto.allocationResponseDto;
import HRMS.hrms.assets.allocation.model.allocationModel;
import org.springframework.stereotype.Component;

@Component
public class allocationToDtoMapper {

    public allocationResponseDto toDto(allocationModel allocation) {

        allocationResponseDto response =
                new allocationResponseDto();

        response.setAllocation_Id(allocation.getAllocation_Id());

        if (allocation.getAsset_Id() != null) {
            response.setAsset_Id(
                    allocation.getAsset_Id().getAsset_Id());
        }

        response.setEmployee_Id(allocation.getEmployee_Id());
        response.setAllocation_Date(allocation.getAllocation_Date());
        response.setExpected_ReturnDate(
                allocation.getExpected_ReturnDate());
        response.setActual_ReturnDate(allocation.getActual_ReturnDate());
        response.setAllocation_Status(allocation.getAllocation_Status());
        response.setAllocation_Purpose(allocation.getAllocation_Purpose());
        response.setAllocated_By(allocation.getAllocated_By());
        response.setAllocation_Remarks(allocation.getAllocation_Remarks());
        response.setAllocation_CreatedAt(
                allocation.getAllocation_CreatedAt());
        response.setAllocation_UpdatedAt(
                allocation.getAllocation_UpdatedAt());

        return response;
    }
}