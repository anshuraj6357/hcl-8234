package HRMS.hrms.attendance.shift.service;

import HRMS.hrms.attendance.shift.dto.shiftRequestDto;
import HRMS.hrms.attendance.shift.dto.shiftResponseDto;
import java.util.List;

public interface shiftService {
    shiftResponseDto create(shiftRequestDto dto);
    shiftResponseDto getById(Long id);
    List<shiftResponseDto> getAll();
    shiftResponseDto update(Long id, shiftRequestDto dto);
    void delete(Long id);
}
