package HRMS.hrms.attendance.overTimerequest.dto;
import java.time.LocalDate;
import java.time.LocalTime;

public class overTimeResponseDto {
    private Long id;
    private Long employeeId;
    private LocalDate overtimeDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long requestedMinutes;
    private String reason;
    private String status;
    private Long reviewedBy;
    private String reviewRemarks;

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
