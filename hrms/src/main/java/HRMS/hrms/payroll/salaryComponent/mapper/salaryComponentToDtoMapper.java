package HRMS.hrms.payroll.salaryComponent.mapper;

import org.springframework.stereotype.Component;
import HRMS.hrms.payroll.salaryComponent.dto.salaryComponentResponseDto;
import HRMS.hrms.payroll.salaryComponent.model.salaryComponentModel;




@Component
public class salaryComponentToDtoMapper {



    public salaryComponentResponseDto toDto(salaryComponentModel salaryComponent){
        salaryComponentResponseDto salaryComponentModel = new salaryComponentResponseDto();
        salaryComponentModel.setSalaryComponent_Active(salaryComponent.getSalaryComponent_Active());
        salaryComponentModel.setSalaryComponent_Name(salaryComponent.getSalaryComponent_Name());
        salaryComponentModel.setSalaryComponent_Code(salaryComponent.getSalaryComponent_Code());
        salaryComponentModel.setSalaryComponent_Type(salaryComponent.getSalaryComponent_Type());
        salaryComponentModel.setSalaryComponent_Value(salaryComponent.getSalaryComponent_Value());
        salaryComponentModel.setSalaryComponent_CalculationType(salaryComponent.getSalaryComponent_CalculationType());
        return salaryComponentModel;

    }
}
