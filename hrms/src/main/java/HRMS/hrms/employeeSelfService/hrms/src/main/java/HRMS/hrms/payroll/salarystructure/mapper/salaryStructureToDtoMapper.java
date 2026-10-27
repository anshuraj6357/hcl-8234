
package HRMS.hrms.payroll.salarystructure.mapper;

import HRMS.hrms.payroll.salarystructure.model.salaryStructureModel;
import HRMS.hrms.payroll.salarystructure.dto.salaryStructureResponseDto;

public class salaryStructureToDtoMapper {

    public static salaryStructureResponseDto toDto(
            salaryStructureModel model) {

        if (model == null) {
            return null;
        }

        salaryStructureResponseDto dto =
                new salaryStructureResponseDto();

        dto.setSalaryStructure_Id(
                model.getSalaryStructure_Id());

        dto.setSalaryStructure_Code(
                model.getSalaryStructure_Code());

        dto.setSalaryStructure_Name(
                model.getSalaryStructure_Name());

        dto.setSalaryStructure_BasicSalary(
                model.getSalaryStructure_BasicSalary());

        dto.setSalaryStructure_HraPercentage(
                model.getSalaryStructure_HraPercentage());

        dto.setSalaryStructure_PfPercentage(
                model.getSalaryStructure_PfPercentage());

        dto.setSalaryStructure_Active(
                model.getSalaryStructure_Active());

        dto.setSalaryStructure_Description(
                model.getSalaryStructure_Description());

        if (model.getBranch_Id() != null) {
            dto.setBranch_Id(
                    model.getBranch_Id().getBranch_Id());
        }

        return dto;
    }
}
