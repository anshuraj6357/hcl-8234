
package HRMS.hrms.organisation.designation.repository;

import HRMS.hrms.organisation.designation.model.designationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface designationRepo
        extends JpaRepository<designationModel, Long> {

    // Department ID ke basis par designations fetch karna
    List<designationModel> findByDepartment_Department_Id(Long departmentId);

    // Designation code duplicate hai ya nahi check karna
    boolean existsByDesignation_Code(String designationCode);
}
