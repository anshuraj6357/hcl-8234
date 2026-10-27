package HRMS.hrms.attendance.shift.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class shiftRequestDto {
    private String shiftName;
    private String startTime;
    private String endTime;
    private Integer graceMinutes;
    private Boolean active;
}
