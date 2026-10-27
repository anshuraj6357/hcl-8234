package HRMS.hrms.assets.conditions.repository;

import HRMS.hrms.assets.conditions.model.conditionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface conditionsRepository
        extends JpaRepository<conditionsModel, Long> {

}