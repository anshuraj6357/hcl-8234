package HRMS.hrms.attendance.overTimerequest.mapper;
import HRMS.hrms.attendance.overTimerequest.dto.overTimeResponseDto;
import HRMS.hrms.attendance.overTimerequest.model.overTimeRequestModel;
import org.springframework.stereotype.Component;

@Component
public class overTimeRequestToDtoMapper {
    public overTimeResponseDto toDto(overTimeRequestModel m) {
        overTimeResponseDto d = new overTimeResponseDto();
        d.setId(m.getId()); d.setEmployeeId(m.getEmployeeId()); d.setOvertimeDate(m.getOvertimeDate());
        d.setStartTime(m.getStartTime()); d.setEndTime(m.getEndTime()); d.setRequestedMinutes(m.getRequestedMinutes());
        d.setReason(m.getReason()); d.setStatus(m.getStatus()); d.setReviewedBy(m.getReviewedBy());
        d.setReviewRemarks(m.getReviewRemarks());
        return d;
    }
}
