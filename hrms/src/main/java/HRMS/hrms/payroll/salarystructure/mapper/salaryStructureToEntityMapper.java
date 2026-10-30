
package HRMS.hrms.payroll.salarystructure.mapper;

import HRMS.hrms.payroll.salarystructure.model.salaryStructureModel;
import HRMS.hrms.payroll.salarystructure.dto.salaryStructureRequestDto;
import HRMS.hrms.organisation.branch.model.branchModel;

public class salaryStructureToEntityMapper {

    public static salaryStructureModel toEntity(
            salaryStructureRequestDto dto,
            branchModel branch) {

        if (dto == null) {
            return null;
        }

        salaryStructureModel model = new salaryStructureModel();

        model.setSalaryStructure_Code(
                dto.getSalaryStructure_Code());

        model.setSalaryStructure_Name(
                dto.getSalaryStructure_Name());

        model.setSalaryStructure_BasicSalary(
                dto.getSalaryStructure_BasicSalary());

        model.setSalaryStructure_HraPercentage(
                dto.getSalaryStructure_HraPercentage());

        model.setSalaryStructure_PfPercentage(
                dto.getSalaryStructure_PfPercentage());

        model.setSalaryStructure_Active(
                dto.getSalaryStructure_Active() != null
                        ? dto.getSalaryStructure_Active()
                        : true);

        model.setSalaryStructure_Description(
                dto.getSalaryStructure_Description());

        model.setBranch_Id(branch);


        return model;
    }
}
