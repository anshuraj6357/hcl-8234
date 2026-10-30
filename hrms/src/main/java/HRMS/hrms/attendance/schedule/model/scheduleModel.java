package HRMS.hrms.attendance.schedule.model;

import HRMS.hrms.employee.model.employeeModel;
import HRMS.hrms.attendance.shift.model.shiftModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id",
        insertable = false, updatable = false,
        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private employeeModel employee;
    @Column(name = "shift_id", nullable = false)
    private Long shiftId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_id", referencedColumnName = "id",
        insertable = false, updatable = false,
        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private shiftModel shift;
    @Column(name = "schedule_date", nullable = false)
    private LocalDate scheduleDate;
    private String status = "ASSIGNED";
    private String remarks;

}
