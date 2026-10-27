package HRMS.hrms.assets.assestMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import HRMS.hrms.assets.assestMaster.model.assestMasterModel;

@Repository
public interface assetMasterRepository extends JpaRepository<assestMasterModel, Long> {

    boolean existsByAssetMaster_Code(String assetMaster_Code);
}