package HRMS.hrms.attendance.shift.mapper;

import HRMS.hrms.attendance.shift.dto.shiftRequestDto;
import HRMS.hrms.attendance.shift.model.shiftModel;
import org.springframework.stereotype.Component;

@Component
public class shiftToUpdateMapper {
    public void updateEntity(shiftModel model, shiftRequestDto dto) {
        if (dto.getShiftName() != null) model.setShiftName(dto.getShiftName());
        if (dto.getStartTime() != null) model.setStartTime(dto.getStartTime());
        if (dto.getEndTime() != null) model.setEndTime(dto.getEndTime());
        if (dto.getGraceMinutes() != null) model.setGraceMinutes(dto.getGraceMinutes());
        if (dto.getActive() != null) model.setActive(dto.getActive());
    }
}
