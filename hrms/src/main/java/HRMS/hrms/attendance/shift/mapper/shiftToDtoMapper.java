package HRMS.hrms.attendance.shift.mapper;

import HRMS.hrms.attendance.shift.dto.shiftResponseDto;
import HRMS.hrms.attendance.shift.model.shiftModel;
import org.springframework.stereotype.Component;

@Component
public class shiftToDtoMapper {
    public shiftResponseDto toDto(shiftModel model) {
        shiftResponseDto dto = new shiftResponseDto();
        dto.setId(model.getId());
        dto.setShiftName(model.getShiftName());
        dto.setStartTime(model.getStartTime());
        dto.setEndTime(model.getEndTime());
        dto.setGraceMinutes(model.getGraceMinutes());
        dto.setActive(model.getActive());
        return dto;
    }
}
