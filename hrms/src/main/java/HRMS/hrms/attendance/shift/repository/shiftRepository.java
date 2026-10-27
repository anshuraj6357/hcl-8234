package HRMS.hrms.attendance.shift.repository;

import HRMS.hrms.attendance.shift.model.shiftModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface shiftRepository extends JpaRepository<shiftModel, Long> {
    boolean existsByShiftNameIgnoreCase(String shiftName);
}
