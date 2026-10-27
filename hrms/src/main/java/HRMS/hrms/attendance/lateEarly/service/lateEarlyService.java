
package HRMS.hrms.attendance.lateEarly.service;

import HRMS.hrms.attendance.lateEarly.dto.lateEarlyRequestDto;
import HRMS.hrms.attendance.lateEarly.dto.lateEarlyResponseDto;

import java.util.List;

public interface lateEarlyService {

    lateEarlyResponseDto create(lateEarlyRequestDto dto);

    lateEarlyResponseDto getById(Long id);

    List<lateEarlyResponseDto> getAll();

    lateEarlyResponseDto update(Long id, lateEarlyRequestDto dto);

    void delete(Long id);
}
