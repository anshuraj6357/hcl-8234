package HRMS.hrms.attendance.punch.mapper;
import HRMS.hrms.attendance.punch.dto.punchRequestDto;
import HRMS.hrms.attendance.punch.model.punchModel;
import org.springframework.stereotype.Component;

@Component
public class punchToEntityMapper {
    public punchModel toEntity(punchRequestDto dto) {
        punchModel m = new punchModel();
        m.setEmployeeId(dto.getEmployeeId()); m.setPunchTime(dto.getPunchTime());
        m.setPunchType(dto.getPunchType() == null ? null : dto.getPunchType().trim().toUpperCase());
        m.setSource(dto.getSource() == null ? "WEB" : dto.getSource());
        m.setRemarks(dto.getRemarks());
        return m;
    }
}
