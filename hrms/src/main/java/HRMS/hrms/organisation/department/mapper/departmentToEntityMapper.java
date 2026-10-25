
package HRMS.hrms.organisation.department.mapper;

import HRMS.hrms.organisation.department.dto.departmentRequestDto;
import HRMS.hrms.organisation.department.model.departmentModel;
import HRMS.hrms.organisation.company.model.companyModel;
import org.springframework.stereotype.Component;

@Component
public class departmentToEntityMapper {

    public departmentModel toEntity(
            departmentRequestDto dto,
            companyModel company) {

        departmentModel department = new departmentModel();

        department.setDepartment_Name(dto.getDepartment_Name());
        department.setDepartment_Code(dto.getDepartment_Code());
        department.setDepartment_Description(
                dto.getDepartment_Description());

        if (dto.getDepartment_Active() != null) {
            department.setDepartment_Active(
                    dto.getDepartment_Active());
        } else {
            department.setDepartment_Active(true);
        }

        department.setCompany(company);

        return department;
    }
}
