package HRMS.hrms.attendance.punch.service;
import HRMS.hrms.attendance.punch.dto.punchRequestDto;
import HRMS.hrms.attendance.punch.dto.punchResponseDto;
import java.util.List;

public interface punchService {
//    punchResponseDto create(punchRequestDto dto);
    punchResponseDto getById(Long id);
    List<punchResponseDto> getAll();
    List<punchResponseDto> getByEmployee(Long employeeId);
    punchResponseDto update(Long id, punchRequestDto dto);
    void delete(Long id);
}
