
package HRMS.hrms.attendance.lateEarly.mapper;

import HRMS.hrms.attendance.lateEarly.dto.lateEarlyResponseDto;
import HRMS.hrms.attendance.lateEarly.model.lateEarlyModel;

import org.springframework.stereotype.Component;

@Component
public class lateEarlyToDtoMapper {

    public lateEarlyResponseDto toDto(lateEarlyModel model) {

        lateEarlyResponseDto dto = new lateEarlyResponseDto();

        dto.setId(model.getId());
        dto.setEmployeeId(model.getEmployeeId());
        dto.setAttendanceDate(model.getAttendanceDate());

        dto.setLate(model.isLate());
        dto.setEarly(model.isEarly());

        dto.setLateMinutes(model.getLateMinutes());
        dto.setEarlyMinutes(model.getEarlyMinutes());

        return dto;
    }
}
