
package HRMS.hrms.attendance.attendance.mapper;

import HRMS.hrms.attendance.attendance.dto.attendanceRequestDto;
import HRMS.hrms.attendance.attendance.model.attendanceModel;
import org.springframework.stereotype.Component;

@Component
public class attendanceToEntityMapper {

    public attendanceModel toEntity(attendanceRequestDto dto) {
        if (dto == null) {
            return null;
        }

        attendanceModel model = new attendanceModel();

        model.setEmployee_Id(dto.getEmployee_Id());
        model.setAttendance_Date(dto.getAttendance_Date());
        model.setAttendance_CheckIn(dto.getAttendance_CheckIn());
        model.setAttendance_CheckOut(dto.getAttendance_CheckOut());
        model.setAttendance_Status(
                dto.getAttendance_Status() != null
                        ? dto.getAttendance_Status()
                        : "PRESENT"
        );
        model.setAttendance_WorkingHours(dto.getAttendance_WorkingHours());
        model.setAttendance_Remarks(dto.getAttendance_Remarks());

        return model;
    }
}
