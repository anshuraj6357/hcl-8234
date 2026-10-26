
package payroll.salarystructure.mapper;

import payroll.salarystructure.model.salaryStructureModel;
import payroll.salarystructure.dto.salaryStructureRequestDto;

public class salaryStructureToUpdateEntityMapper {

    public static salaryStructureModel toUpdateEntity(
            salaryStructureModel model,
            salaryStructureRequestDto request) {

        if (model == null || request == null) {
            return model;
        }

        model.setSalaryStructure_Code(
                request.getSalaryStructure_Code());

        model.setSalaryStructure_Name(
                request.getSalaryStructure_Name());

        model.setSalaryStructure_BasicSalary(
                request.getSalaryStructure_BasicSalary());

        model.setSalaryStructure_HraPercentage(
                request.getSalaryStructure_HraPercentage());

        model.setSalaryStructure_PfPercentage(
                request.getSalaryStructure_PfPercentage());

        model.setSalaryStructure_Description(
                request.getSalaryStructure_Description());

        if (request.getSalaryStructure_Active() != null) {
            model.setSalaryStructure_Active(
                    request.getSalaryStructure_Active());
        }

        return model;
    }
}
