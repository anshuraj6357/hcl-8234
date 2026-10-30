
package HRMS.hrms.attendance.lateEarly.model;

import HRMS.hrms.employee.model.employeeModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "late_early")
@Getter
@Setter

public class lateEarlyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id",
        insertable = false, updatable = false,
        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private employeeModel employee;
    private LocalDate attendanceDate;
    private LocalTime shiftStartTime;
    private LocalTime shiftEndTime;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;

    private boolean late;
    private boolean early;
    private long lateMinutes;
    private long earlyMinutes;

}
