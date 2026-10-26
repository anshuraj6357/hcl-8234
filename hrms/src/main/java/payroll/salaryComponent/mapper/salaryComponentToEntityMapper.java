
package payroll.salaryComponent.mapper;

import org.springframework.stereotype.Component;
import payroll.salaryComponent.dto.salaryComponentRequestDto;
import payroll.salaryComponent.model.salaryComponentModel;




@Component
public class salaryComponentToEntityMapper {

    public salaryComponentModel toEntity(
            salaryComponentRequestDto salaryComponent) {

        salaryComponentModel model = new salaryComponentModel();

        model.setSalaryComponent_Active(
                salaryComponent.getSalaryComponent_Active());

        model.setSalaryComponent_Name(
                salaryComponent.getSalaryComponent_Name());

        model.setSalaryComponent_Code(
                 salaryComponent.getSalaryComponent_Code());

        model.setSalaryComponent_Type(
                salaryComponent.getSalaryComponent_Type());

        model.setSalaryComponent_Value(salaryComponent.getSalaryComponent_Value());

        model.setSalaryComponent_CalculationType(
                salaryComponent.getSalaryComponent_CalculationType());

        return model;
    }
}
