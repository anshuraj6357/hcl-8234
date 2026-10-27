
package HRMS.hrms.attendance.attendance.mapper;

import HRMS.hrms.attendance.attendance.dto.attendanceRequestDto;
import HRMS.hrms.attendance.attendance.model.attendanceModel;
import org.springframework.stereotype.Component;

@Component
public class attendanceToUpdateMapper {

    public void updateEntity(
            attendanceModel model,
            attendanceRequestDto dto
    ) {
        if (model == null || dto == null) {
            return;
        }

        if (dto.getEmployee_Id() != null) {
            model.setEmployee_Id(dto.getEmployee_Id());
        }

        if (dto.getAttendance_Date() != null) {
            model.setAttendance_Date(dto.getAttendance_Date());
        }

        if (dto.getAttendance_CheckIn() != null) {
            model.setAttendance_CheckIn(dto.getAttendance_CheckIn());
        }

        if (dto.getAttendance_CheckOut() != null) {
            model.setAttendance_CheckOut(dto.getAttendance_CheckOut());
        }

        if (dto.getAttendance_Status() != null) {
            model.setAttendance_Status(dto.getAttendance_Status());
        }

        if (dto.getAttendance_WorkingHours() != null) {
            model.setAttendance_WorkingHours(dto.getAttendance_WorkingHours());
        }

        if (dto.getAttendance_Remarks() != null) {
            model.setAttendance_Remarks(dto.getAttendance_Remarks());
        }
    }
}
