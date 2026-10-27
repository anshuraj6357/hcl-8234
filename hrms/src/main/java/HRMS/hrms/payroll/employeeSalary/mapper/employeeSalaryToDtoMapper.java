
package HRMS.hrms.payroll.employeeSalary.mapper;

import org.springframework.stereotype.Component;
import HRMS.hrms.payroll.employeeSalary.dto.employeeSalaryResponseDto;
import HRMS.hrms.payroll.employeeSalary.model.employeeSalaryModel;


@Component
public class employeeSalaryToDtoMapper {

    // Model -> Response DTO
    public  employeeSalaryResponseDto toDto(
            employeeSalaryModel model) {

        employeeSalaryResponseDto dto =
                new employeeSalaryResponseDto();

        dto.setEmployeeSalary_Id(
                model.getEmployeeSalary_Id());

        dto.setEmployeeId(
                model.getEmployeeId());

        dto.setSalaryStructureId(
                model.getSalaryStructure()
                        .getSalaryStructure_Id());

        dto.setEmployeeSalary_GrossSalary(
                model.getEmployeeSalary_GrossSalary());

        dto.setEmployeeSalary_EffectiveFrom(
                model.getEmployeeSalary_EffectiveFrom());

        dto.setEmployeeSalary_EffectiveTo(
                model.getEmployeeSalary_EffectiveTo());

        dto.setEmployeeSalary_Active(
                model.getEmployeeSalary_Active());

        return dto;
    }
}
