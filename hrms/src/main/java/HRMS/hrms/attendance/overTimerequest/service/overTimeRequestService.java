package HRMS.hrms.attendance.overTimerequest.service;
import HRMS.hrms.attendance.overTimerequest.dto.overTimeRequestDto;
import HRMS.hrms.attendance.overTimerequest.dto.overTimeResponseDto;
import java.util.List;

public interface overTimeRequestService {
    overTimeResponseDto create(overTimeRequestDto dto);
    overTimeResponseDto getById(Long id);
    List<overTimeResponseDto> getAll();
    List<overTimeResponseDto> getByEmployee(Long employeeId);
    overTimeResponseDto update(Long id, overTimeRequestDto dto);
    overTimeResponseDto review(Long id, Long reviewerId, String status, String remarks);
    void delete(Long id);
}
