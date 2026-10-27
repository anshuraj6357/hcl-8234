
package HRMS.hrms.payroll.salaryComponent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import HRMS.hrms.payroll.salaryComponent.model.salaryComponentModel;

import java.util.List;

public interface salaryComponentRepository
        extends JpaRepository<salaryComponentModel, Long> {

    List<salaryComponentModel> findByBranch_Branch_Id(Long branchId);
}
