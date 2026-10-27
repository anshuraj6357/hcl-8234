
package HRMS.hrms.payroll.employeeSalary.repository;

import org.springframework.stereotype.Repository;
import HRMS.hrms.payroll.employeeSalary.model.employeeSalaryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface employeeSalaryRepository
        extends JpaRepository<employeeSalaryModel, Long> {

    List<employeeSalaryModel> findByEmployeeId(Long employeeId);
}
