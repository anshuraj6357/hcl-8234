package HRMS.hrms.attendance.shift.mapper;

import HRMS.hrms.attendance.shift.dto.shiftRequestDto;
import HRMS.hrms.attendance.shift.model.shiftModel;
import org.springframework.stereotype.Component;

@Component
public class shiftToEntityMapper {
    public shiftModel toEntity(shiftRequestDto dto) {
        shiftModel model = new shiftModel();
        updateFields(model, dto);
        return model;
    }
    public void updateFields(shiftModel model, shiftRequestDto dto) {
        model.setShiftName(dto.getShiftName());
        model.setStartTime(dto.getStartTime());
        model.setEndTime(dto.getEndTime());
        model.setGraceMinutes(dto.getGraceMinutes() == null ? 0 : dto.getGraceMinutes());
        model.setActive(dto.getActive() == null ? true : dto.getActive());
    }
}
