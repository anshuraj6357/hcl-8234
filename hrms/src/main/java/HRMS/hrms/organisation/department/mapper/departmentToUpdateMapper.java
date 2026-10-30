package HRMS.hrms.organisation.department.mapper;

import HRMS.hrms.organisation.department.dto.departmentRequestDto;
import HRMS.hrms.organisation.department.model.departmentModel;
import org.springframework.stereotype.Component;

@Component
public class departmentToUpdateMapper {

    public departmentModel toUpdate(
            departmentRequestDto dto,
            departmentModel department) {
        if (dto.getDepartment_Name() != null) {
            department.setDepartment_Name(dto.getDepartment_Name());
        }
        if (dto.getDepartment_Code() != null) {
            department.setDepartment_Code(dto.getDepartment_Code());
        }
        if (dto.getDepartment_Description() != null) {
            department.setDepartment_Description(dto.getDepartment_Description());
        }
        if (dto.getDepartment_Active() != null) {
            department.setDepartment_Active(dto.getDepartment_Active());
        }
        return department;
    }
}
