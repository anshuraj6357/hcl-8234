package payroll.employeeSalary.repository;

import HRMS.hrms.employee.model.employeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSalaryRepository extends JpaRepository<employeeModel,Long> {
}
