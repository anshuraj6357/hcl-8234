
package HRMS.hrms.attendance.lateEarly.mapper;

import HRMS.hrms.attendance.lateEarly.dto.lateEarlyRequestDto;
import HRMS.hrms.attendance.lateEarly.model.lateEarlyModel;

import org.springframework.stereotype.Component;

@Component
public class lateEarlyToUpdateMapper {

    public void updateEntity(
            lateEarlyModel model,
            lateEarlyRequestDto dto) {

        model.setEmployeeId(dto.getEmployeeId());
        model.setAttendanceDate(dto.getAttendanceDate());
        model.setShiftStartTime(dto.getShiftStartTime());
        model.setShiftEndTime(dto.getShiftEndTime());
        model.setCheckInTime(dto.getCheckInTime());
        model.setCheckOutTime(dto.getCheckOutTime());
    }
}
