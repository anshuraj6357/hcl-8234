package HRMS.hrms.organisation.company.Repository;

import HRMS.hrms.organisation.company.model.companyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface companyRepository extends JpaRepository<companyModel, Long> {

}
