package HRMS.hrms.organisation.branch.repository;


import HRMS.hrms.organisation.branch.model.branchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface branchRepo extends JpaRepository<branchModel,Long> {
}
