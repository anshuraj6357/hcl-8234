package HRMS.hrms.assets.allocation.mapper;

import HRMS.hrms.assets.allocation.dto.allocationRequestDto;
import HRMS.hrms.assets.allocation.model.allocationModel;
import org.springframework.stereotype.Component;

@Component
public class allocationToUpdateMapper {

    public allocationModel toUpdateEntity(
            allocationModel allocation,
            allocationRequestDto request) {

        allocation.setEmployee_Id(request.getEmployee_Id());
        allocation.setAllocation_Date(request.getAllocation_Date());
        allocation.setExpected_ReturnDate(request.getExpected_ReturnDate());
        allocation.setActual_ReturnDate(request.getActual_ReturnDate());
        allocation.setAllocation_Status(request.getAllocation_Status());
        allocation.setAllocation_Purpose(request.getAllocation_Purpose());
        allocation.setAllocated_By(request.getAllocated_By());
        allocation.setAllocation_Remarks(request.getAllocation_Remarks());

        return allocation;
    }
}