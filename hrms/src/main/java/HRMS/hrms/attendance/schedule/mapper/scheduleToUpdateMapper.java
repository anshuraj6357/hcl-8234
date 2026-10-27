package HRMS.hrms.attendance.schedule.mapper;
import HRMS.hrms.attendance.schedule.dto.scheduleRequestDto;
import HRMS.hrms.attendance.schedule.model.scheduleModel;
import org.springframework.stereotype.Component;

@Component
public class scheduleToUpdateMapper {
    public void updateEntity(scheduleModel m, scheduleRequestDto dto) {
        if (dto.getEmployeeId() != null) m.setEmployeeId(dto.getEmployeeId());
        if (dto.getShiftId() != null) m.setShiftId(dto.getShiftId());
        if (dto.getScheduleDate() != null) m.setScheduleDate(dto.getScheduleDate());
        if (dto.getStatus() != null) m.setStatus(dto.getStatus());
        if (dto.getRemarks() != null) m.setRemarks(dto.getRemarks());
    }
}
