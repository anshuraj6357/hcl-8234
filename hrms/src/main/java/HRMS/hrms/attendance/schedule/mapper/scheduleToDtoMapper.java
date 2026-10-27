package HRMS.hrms.attendance.schedule.mapper;
import HRMS.hrms.attendance.schedule.dto.scheduleResponseDto;
import HRMS.hrms.attendance.schedule.model.scheduleModel;
import org.springframework.stereotype.Component;

@Component
public class scheduleToDtoMapper {
    public scheduleResponseDto toDto(scheduleModel m) {
        scheduleResponseDto d = new scheduleResponseDto();
        d.setId(m.getId()); d.setEmployeeId(m.getEmployeeId()); d.setShiftId(m.getShiftId());
        d.setScheduleDate(m.getScheduleDate()); d.setStatus(m.getStatus()); d.setRemarks(m.getRemarks());
        return d;
    }
}
