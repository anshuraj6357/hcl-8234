package HRMS.hrms.payroll.salarystructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import HRMS.hrms.payroll.salarystructure.model.salaryStructureModel;


@Repository
public interface salaryStructureRepository extends JpaRepository<salaryStructureModel,Long> {
}
