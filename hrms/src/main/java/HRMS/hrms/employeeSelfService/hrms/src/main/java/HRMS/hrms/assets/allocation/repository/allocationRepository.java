package HRMS.hrms.assets.allocation.repository;

import HRMS.hrms.assets.allocation.model.allocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface allocationRepository extends JpaRepository<allocationModel, Long> {
}
