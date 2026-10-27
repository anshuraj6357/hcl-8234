package HRMS.hrms.attendance.lateEarly.repository;

import HRMS.hrms.attendance.lateEarly.model.lateEarlyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface lateEarlyRepository
        extends JpaRepository<lateEarlyModel, Long> {
}
