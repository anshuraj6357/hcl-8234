package HRMS.hrms.attendance.schedule.service;
import HRMS.hrms.attendance.schedule.dto.scheduleRequestDto;
import HRMS.hrms.attendance.schedule.dto.scheduleResponseDto;
import java.time.LocalDate;
import java.util.List;

public interface scheduleService {
    scheduleResponseDto create(scheduleRequestDto dto);
    scheduleResponseDto getById(Long id);
    List<scheduleResponseDto> getAll();
    List<scheduleResponseDto> getByEmployee(Long employeeId);
    List<scheduleResponseDto> getByDate(LocalDate date);
    scheduleResponseDto update(Long id, scheduleRequestDto dto);
    void delete(Long id);
}
