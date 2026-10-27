package HRMS.hrms.attendance.punch.mapper;
import HRMS.hrms.attendance.punch.dto.punchResponseDto;
import HRMS.hrms.attendance.punch.model.punchModel;
import org.springframework.stereotype.Component;

@Component
public class punchToDtoMapper {
    public punchResponseDto toDto(punchModel m) {
        punchResponseDto d = new punchResponseDto();
        d.setId(m.getId()); d.setEmployeeId(m.getEmployeeId()); d.setPunchTime(m.getPunchTime());
        d.setPunchType(m.getPunchType()); d.setSource(m.getSource()); d.setRemarks(m.getRemarks());
        return d;
    }
}
