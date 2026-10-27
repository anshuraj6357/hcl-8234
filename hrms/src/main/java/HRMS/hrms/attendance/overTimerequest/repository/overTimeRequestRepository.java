package HRMS.hrms.attendance.overTimerequest.repository;
import HRMS.hrms.attendance.overTimerequest.model.overTimeRequestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface overTimeRequestRepository extends JpaRepository<overTimeRequestModel, Long> {
    List<overTimeRequestModel> findByEmployeeIdOrderByOvertimeDateDesc(Long employeeId);
}
