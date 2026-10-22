package selfPractise.AnnotationBasedConfiguration;


import org.springframework.stereotype.Service;

@Service
public class PayRollService {
    private final FullTimeSalary fullTimeSalary;
    private final ContractSalary contractSalary;
    public PayRollService(FullTimeSalary fullTimeSalary, ContractSalary contractSalary) {
        this.fullTimeSalary = fullTimeSalary;
        this.contractSalary = contractSalary;
    }

    public void ProcessSalary(Employee e) {
        if(e.getEmployeetype().equals("FullTime")) {
            int salary = fullTimeSalary.CalculateSalary();
            e.setSalary(salary);
        }
        else if(e.getEmployeetype().equals("Payroll")) {
            int salary = contractSalary.CalculateSalary();
        }
    }
}
