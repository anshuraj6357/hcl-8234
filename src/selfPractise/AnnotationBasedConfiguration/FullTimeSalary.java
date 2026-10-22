package selfPractise.AnnotationBasedConfiguration;


import org.springframework.stereotype.Component;

@Component
public class FullTimeSalary implements SalaryCalCulator {
    public int CalculateSalary() {
        return 5000;
    }
}
