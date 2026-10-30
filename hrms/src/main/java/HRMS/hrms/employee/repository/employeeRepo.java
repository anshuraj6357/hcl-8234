package HRMS.hrms.employee.repository;

import HRMS.hrms.employee.model.employeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface employeeRepo extends JpaRepository<employeeModel,Long> {

    Optional<employeeModel> findById(Long id);
    List<employeeModel> findByDepartment(String department);
    List<employeeModel> findByDesignation(String designation);

}
