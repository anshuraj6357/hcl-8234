package HRMS.hrms.attendance.schedule.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "hrms_schedule", uniqueConstraints = @UniqueConstraint(
    name = "uk_schedule_employee_date", columnNames = {"employee_id", "schedule_date"}))
@Getter
@Setter
public class scheduleModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;
    @Column(name = "shift_id", nullable = false)
    private Long shiftId;
    @Column(name = "schedule_date", nullable = false)
    private LocalDate scheduleDate;
    private String status = "ASSIGNED";
    private String remarks;

}
