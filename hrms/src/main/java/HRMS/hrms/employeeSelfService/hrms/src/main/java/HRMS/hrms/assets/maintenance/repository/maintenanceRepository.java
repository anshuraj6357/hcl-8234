package HRMS.hrms.assets.maintenance.repository;

import HRMS.hrms.assets.maintenance.model.maintenanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface maintenanceRepository
        extends JpaRepository<maintenanceModel, Long> {
}