package HRMS.hrms.payroll.salarystructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import HRMS.hrms.payroll.salarystructure.model.salaryStructureModel;
import java.util.List;


@Repository
public interface salaryStructureRepository extends JpaRepository<salaryStructureModel,Long> {
    @Query("SELECT s FROM salaryStructureModel s WHERE s.branch_Id.branch_Id = :branchId")
    List<salaryStructureModel> findByBranchId(@Param("branchId") Long branchId);
}
