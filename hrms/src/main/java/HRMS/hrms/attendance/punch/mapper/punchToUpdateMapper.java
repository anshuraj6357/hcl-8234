package HRMS.hrms.attendance.punch.mapper;
import HRMS.hrms.attendance.punch.dto.punchRequestDto;
import HRMS.hrms.attendance.punch.model.punchModel;
import org.springframework.stereotype.Component;

@Component
public class punchToUpdateMapper {
    public void updateEntity(punchModel m, punchRequestDto dto) {
        if (dto.getEmployeeId() != null) m.setEmployeeId(dto.getEmployeeId());
        if (dto.getPunchTime() != null) m.setPunchTime(dto.getPunchTime());
        if (dto.getPunchType() != null) m.setPunchType(dto.getPunchType().trim().toUpperCase());
        if (dto.getSource() != null) m.setSource(dto.getSource());
        if (dto.getRemarks() != null) m.setRemarks(dto.getRemarks());
    }
}
