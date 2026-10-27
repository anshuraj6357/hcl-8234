
package HRMS.hrms.attendance.attendance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "attendance",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"employee_id", "attendance_date"}
                )
        }
)
@Getter
@Setter
public class attendanceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendance_Id;

    @Column(name = "employee_id", nullable = false)
    private Long employee_Id;

    @Column(name = "attendance_date", nullable = false)
    private LocalDate attendance_Date;

    @Column(name = "check_in")
    private LocalDateTime attendance_CheckIn;

    @Column(name = "check_out")
    private LocalDateTime attendance_CheckOut;

    @Column(name = "attendance_status", nullable = false)
    private String attendance_Status = "PRESENT";

    @Column(name = "working_hours")
    private Double attendance_WorkingHours;

    @Column(name = "remarks", length = 500)
    private String attendance_Remarks;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public attendanceModel() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
