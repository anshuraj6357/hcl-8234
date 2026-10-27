package HRMS.hrms.attendance.overTimerequest.mapper;
import HRMS.hrms.attendance.overTimerequest.dto.overTimeRequestDto;
import HRMS.hrms.attendance.overTimerequest.model.overTimeRequestModel;
import org.springframework.stereotype.Component;
import java.time.Duration;

@Component
public class overTimeRequestToUpdateMapper {
    public void updateEntity(overTimeRequestModel m, overTimeRequestDto dto) {
        if (dto.getEmployeeId() != null) m.setEmployeeId(dto.getEmployeeId());
        if (dto.getOvertimeDate() != null) m.setOvertimeDate(dto.getOvertimeDate());
        if (dto.getStartTime() != null) m.setStartTime(dto.getStartTime());
        if (dto.getEndTime() != null) m.setEndTime(dto.getEndTime());
        if (dto.getStartTime() != null && dto.getEndTime() != null)
            m.setRequestedMinutes(Duration.between(dto.getStartTime(), dto.getEndTime()).toMinutes());
        else if (m.getStartTime() != null && m.getEndTime() != null)
            m.setRequestedMinutes(Duration.between(m.getStartTime(), m.getEndTime()).toMinutes());
        if (dto.getReason() != null) m.setReason(dto.getReason());
    }
}
