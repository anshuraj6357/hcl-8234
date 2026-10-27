
package HRMS.hrms.organisation.department.repository;

import HRMS.hrms.organisation.department.model.departmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface departmentRepo extends JpaRepository<departmentModel, Long> {

    @Query("SELECT d FROM departmentModel d WHERE d.company.company_Id = :companyId")
    List<departmentModel> findDepartmentsByCompanyId(
            @Param("companyId") Long companyId
    );
}
