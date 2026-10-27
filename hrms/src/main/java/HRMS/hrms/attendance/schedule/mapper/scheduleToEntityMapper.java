package HRMS.hrms.attendance.schedule.mapper;
import HRMS.hrms.attendance.schedule.dto.scheduleRequestDto;
import HRMS.hrms.attendance.schedule.model.scheduleModel;
import org.springframework.stereotype.Component;

@Component
public class scheduleToEntityMapper {
    public scheduleModel toEntity(scheduleRequestDto dto) {
        scheduleModel m = new scheduleModel();
        m.setEmployeeId(dto.getEmployeeId()); m.setShiftId(dto.getShiftId());
        m.setScheduleDate(dto.getScheduleDate());
        m.setStatus(dto.getStatus() == null ? "ASSIGNED" : dto.getStatus());
        m.setRemarks(dto.getRemarks());
        return m;
    }
}
