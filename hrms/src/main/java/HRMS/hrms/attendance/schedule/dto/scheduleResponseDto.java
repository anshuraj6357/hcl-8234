package HRMS.hrms.attendance.schedule.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;



@Getter
@Setter
public class scheduleResponseDto {
    private Long id;
    private Long employeeId;
    private Long shiftId;
    private LocalDate scheduleDate;
    private String status;
    private String remarks;
}
