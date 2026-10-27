
package HRMS.hrms.attendance.attendance.mapper;

import HRMS.hrms.attendance.attendance.dto.attendanceResponseDto;
import HRMS.hrms.attendance.attendance.model.attendanceModel;
import org.springframework.stereotype.Component;

@Component
public class attendanceToDtoMapper {

    public attendanceResponseDto toDto(attendanceModel model) {
        if (model == null) {
            return null;
        }

        attendanceResponseDto dto = new attendanceResponseDto();


        dto.setEmployee_Id(model.getEmployee_Id());
        dto.setAttendance_Date(model.getAttendance_Date());
        dto.setAttendance_CheckIn(model.getAttendance_CheckIn());
        dto.setAttendance_CheckOut(model.getAttendance_CheckOut());
        dto.setAttendance_Status(model.getAttendance_Status());
        dto.setAttendance_WorkingHours(model.getAttendance_WorkingHours());
        dto.setAttendance_Remarks(model.getAttendance_Remarks());


        return dto;
    }
}
