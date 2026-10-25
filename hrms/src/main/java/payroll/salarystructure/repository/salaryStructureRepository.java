package payroll.salarystructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payroll.salarystructure.model.salaryStructureModel;

public interface salaryStructureRepository extends JpaRepository<salaryStructureModel,Long> {
}
