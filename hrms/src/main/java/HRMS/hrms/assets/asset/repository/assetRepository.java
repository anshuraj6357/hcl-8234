
package HRMS.hrms.assets.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import HRMS.hrms.assets.asset.model.assetModel;

@Repository
public interface assetRepository extends JpaRepository<assetModel, Long> {

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
            "FROM assetModel a " +
            "WHERE a.asset_Code = :assetCode")
    boolean existsByAssetCode(
            @Param("assetCode") String assetCode
    );

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
            "FROM assetModel a " +
            "WHERE a.asset_SerialNumber = :serialNumber")
    boolean existsByAssetSerialNumber(
            @Param("serialNumber") String serialNumber
    );
}
