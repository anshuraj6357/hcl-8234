
package HRMS.hrms.attendance.attendance.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;



@Getter
@Setter
public class attendanceRequestDto {

    private Long employee_Id;
    private LocalDate attendance_Date;
    private LocalDateTime attendance_CheckIn;
    private LocalDateTime attendance_CheckOut;
    private String attendance_Status;
    private Double attendance_WorkingHours;
    private String attendance_Remarks;


}
