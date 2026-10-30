
package HRMS.hrms.organisation.designation.repository;

import HRMS.hrms.organisation.designation.model.designationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface designationRepo
        extends JpaRepository<designationModel, Long> {

    @Query("SELECT d FROM designationModel d WHERE d.department.department_Id = :departmentId")
    List<designationModel> findByDepartmentId(@Param("departmentId") Integer departmentId);
//
//    // Designation code duplicate hai ya nahi check karna
//    boolean existsByDesignation_Code(String designationCode);
}
