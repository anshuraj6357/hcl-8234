
package HRMS.hrms.attendance.lateEarly.model;

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

    private Long employeeId;
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
