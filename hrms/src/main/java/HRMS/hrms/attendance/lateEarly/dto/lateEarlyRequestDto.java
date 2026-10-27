
package HRMS.hrms.attendance.lateEarly.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;



@Getter
@Setter

public class lateEarlyRequestDto {

    private Long employeeId;
    private LocalDate attendanceDate;
    private LocalTime shiftStartTime;
    private LocalTime shiftEndTime;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;

}
