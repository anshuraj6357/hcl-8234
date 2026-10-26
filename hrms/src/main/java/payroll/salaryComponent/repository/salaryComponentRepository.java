
package payroll.salaryComponent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payroll.salaryComponent.model.salaryComponentModel;

import java.util.List;
import java.util.Optional;

public interface salaryComponentRepository
        extends JpaRepository<salaryComponentModel, Long> {

    List<salaryComponentModel> findByBranch_Branch_Id(Long branchId);
}
