
package HRMS.hrms.organisation.location.Repository;

import HRMS.hrms.organisation.location.model.locationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface locationRepo extends JpaRepository<locationModel, Long> {
    @Query("SELECT l FROM locationModel l WHERE l.company_Id.company_Id = :companyId")
    List<locationModel> findAllByCompany_Id(
            @Param("companyId") Long companyId
    );
}