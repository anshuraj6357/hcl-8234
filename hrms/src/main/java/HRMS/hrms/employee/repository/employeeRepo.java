package HRMS.hrms.employee.repository;

import HRMS.hrms.employee.model.employeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface employeeRepo extends JpaRepository<employeeModel,String> {

    Optional<employeeModel> findById(Long id);
    Optional<employeeModel> findByDepartment(String department);
    Optional<employeeModel> findByDesignation(String designation);

}
