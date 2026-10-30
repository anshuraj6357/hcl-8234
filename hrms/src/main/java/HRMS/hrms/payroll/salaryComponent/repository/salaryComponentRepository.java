
package HRMS.hrms.payroll.salaryComponent.repository;

import HRMS.hrms.payroll.salaryComponent.model.salaryComponentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface salaryComponentRepository
        extends JpaRepository<salaryComponentModel, Long> {

    @Query("SELECT s FROM salaryComponentModel s " +
            "WHERE s.branch_Id.branch_Id = :branchId")
    List<salaryComponentModel> findByBranchId(
            @Param("branchId") Long branchId
    );
}
