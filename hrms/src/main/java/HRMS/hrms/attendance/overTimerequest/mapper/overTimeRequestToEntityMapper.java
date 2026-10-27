package HRMS.hrms.attendance.overTimerequest.mapper;
import HRMS.hrms.attendance.overTimerequest.dto.overTimeRequestDto;
import HRMS.hrms.attendance.overTimerequest.model.overTimeRequestModel;
import org.springframework.stereotype.Component;
import java.time.Duration;

@Component
public class overTimeRequestToEntityMapper {
    public overTimeRequestModel toEntity(overTimeRequestDto dto) {
        overTimeRequestModel m = new overTimeRequestModel();
        m.setEmployeeId(dto.getEmployeeId()); m.setOvertimeDate(dto.getOvertimeDate());
        m.setStartTime(dto.getStartTime()); m.setEndTime(dto.getEndTime());
        m.setRequestedMinutes(Duration.between(dto.getStartTime(), dto.getEndTime()).toMinutes());
        m.setReason(dto.getReason()); m.setStatus("PENDING");
        return m;
    }
}
