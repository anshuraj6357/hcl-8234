package payroll.employeeSalary.mapper;

import payroll.employeeSalary.dto.employeeSalaryRequestDto;
import payroll.employeeSalary.model.employeeSalaryModel;

public class employeeSalaryToEntityMapper {



    // Request DTO ko Model mein convert karna
    public static employeeSalaryModel toModel(
            employeeSalaryRequestDto dto) {

        employeeSalaryModel model =
                new employeeSalaryModel();

        model.setEmployeeId(dto.getEmployeeId());

        model.setEmployeeSalary_GrossSalary(
                dto.getEmployeeSalary_GrossSalary());

        model.setEmployeeSalary_EffectiveFrom(
                dto.getEmployeeSalary_EffectiveFrom());

        model.setEmployeeSalary_EffectiveTo(
                dto.getEmployeeSalary_EffectiveTo());

        model.setEmployeeSalary_Active(
                dto.getEmployeeSalary_Active());

        return model;
    }
}
