
package HRMS.hrms.attendance.lateEarly.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class lateEarlyResponseDto {

    private Long id;
    private Long employeeId;
    private LocalDate attendanceDate;
    private boolean late;
    private boolean early;
    private long lateMinutes;
    private long earlyMinutes;
}
