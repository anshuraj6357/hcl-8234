package HRMS.hrms.attendance.punch.repository;
import HRMS.hrms.attendance.punch.model.punchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface punchRepository extends JpaRepository<punchModel, Long> {
    List<punchModel> findByEmployeeIdOrderByPunchTimeDesc(Long employeeId);
}
