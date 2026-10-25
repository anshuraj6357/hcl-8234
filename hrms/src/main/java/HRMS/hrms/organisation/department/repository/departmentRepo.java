
package HRMS.hrms.organisation.department.repository;

import HRMS.hrms.organisation.department.model.departmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface departmentRepo extends JpaRepository<departmentModel, Integer> {

    // Company ID ke basis par departments fetch karna
    List<departmentModel> findByCompany_Company_Id(Long companyId);

}
