package HRMS.hrms.attendance.punch.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class punchRequestDto {
    private Long employeeId;
    private LocalDateTime punchTime;
    private String punchType;
    private String source;
    private String remarks;
}
