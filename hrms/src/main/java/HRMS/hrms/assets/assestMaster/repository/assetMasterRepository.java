
package HRMS.hrms.assets.assestMaster.repository;

import HRMS.hrms.assets.assestMaster.model.assestMasterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface assetMasterRepository
        extends JpaRepository<assestMasterModel, Long> {

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
            "FROM assestMasterModel a " +
            "WHERE a.assetMaster_Code = :code")
    boolean existsByAssetMasterCode(@Param("code") String code);
}
