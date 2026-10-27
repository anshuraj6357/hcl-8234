package HRMS.hrms.attendance.attendance.repository;


import HRMS.hrms.attendance.attendance.model.attendanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface attendanceRepository extends JpaRepository<attendanceModel,Long> {
}
