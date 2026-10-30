package HRMS.hrms.attendance.overTimerequest.model;

import HRMS.hrms.auth.model.authModelUser;
import HRMS.hrms.employee.model.employeeModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "hrms_overtime_request")
public class overTimeRequestModel {
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
    @Column(nullable = false)
    private LocalDate overtimeDate;
    @Column(nullable = false)
    private LocalTime startTime;
    @Column(nullable = false)
    private LocalTime endTime;
    private Long requestedMinutes;
    @Column(length = 1000)
    private String reason;
    private String status = "PENDING";
    @Column(name = "reviewed_by")
    private Long reviewedBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewed_by", referencedColumnName = "id",
        insertable = false, updatable = false,
        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private authModelUser reviewer;
    private String reviewRemarks;

    public overTimeRequestModel() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    public LocalDate getOvertimeDate() { return overtimeDate; }
    public void setOvertimeDate(LocalDate overtimeDate) { this.overtimeDate = overtimeDate; }
    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
    public Long getRequestedMinutes() { return requestedMinutes; }
    public void setRequestedMinutes(Long requestedMinutes) { this.requestedMinutes = requestedMinutes; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getReviewedBy() { return reviewedBy; }
    public void setReviewedBy(Long reviewedBy) { this.reviewedBy = reviewedBy; }
    public String getReviewRemarks() { return reviewRemarks; }
    public void setReviewRemarks(String reviewRemarks) { this.reviewRemarks = reviewRemarks; }
}
