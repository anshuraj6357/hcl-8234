
package HRMS.hrms.attendance.lateEarly.mapper;

import HRMS.hrms.attendance.lateEarly.dto.lateEarlyRequestDto;
import HRMS.hrms.attendance.lateEarly.model.lateEarlyModel;

import org.springframework.stereotype.Component;

@Component
public class lateEarlyToEntityMapper {

    public lateEarlyModel toEntity(lateEarlyRequestDto dto) {

        lateEarlyModel model = new lateEarlyModel();

        model.setEmployeeId(dto.getEmployeeId());
        model.setAttendanceDate(dto.getAttendanceDate());
        model.setShiftStartTime(dto.getShiftStartTime());
        model.setShiftEndTime(dto.getShiftEndTime());
        model.setCheckInTime(dto.getCheckInTime());
        model.setCheckOutTime(dto.getCheckOutTime());

        return model;
    }
}
