package HRMS.hrms.assets.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HRMS.hrms.assets.asset.model.assetModel;

@Repository
public interface assetRepository
        extends JpaRepository<assetModel, Long> {

    boolean existsByAsset_Code(String asset_Code);

    boolean existsByAsset_SerialNumber(String asset_SerialNumber);
}