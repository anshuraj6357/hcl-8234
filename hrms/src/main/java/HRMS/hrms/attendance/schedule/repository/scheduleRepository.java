package HRMS.hrms.attendance.schedule.repository;
import HRMS.hrms.attendance.schedule.model.scheduleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface scheduleRepository extends JpaRepository<scheduleModel, Long> {
    List<scheduleModel> findByEmployeeId(Long employeeId);
    List<scheduleModel> findByScheduleDate(LocalDate scheduleDate);
    boolean existsByEmployeeIdAndScheduleDate(Long employeeId, LocalDate scheduleDate);
}
