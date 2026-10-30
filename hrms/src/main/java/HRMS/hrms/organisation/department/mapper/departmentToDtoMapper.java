
package HRMS.hrms.organisation.department.mapper;

import HRMS.hrms.organisation.department.dto.departmentResponseDto;
import HRMS.hrms.organisation.department.model.departmentModel;
import org.springframework.stereotype.Component;

@Component
public class departmentToDtoMapper {

    public departmentResponseDto departmentToDto(
            departmentModel department) {

        departmentResponseDto response =
                new departmentResponseDto();

        response.setDepartment_Id(department.getDepartment_Id());
        response.setDepartment_Code(department.getDepartment_Code());
        response.setDepartment_Name(department.getDepartment_Name());
        response.setDepartment_Description(
                department.getDepartment_Description());
        response.setDepartment_Active(department.getDepartment_Active());

        if (department.getCompany() != null) {
            response.setCompanyId(
                    department.getCompany().getCompany_Id());
        }

        return response;
    }
}
