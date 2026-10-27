
package HRMS.hrms.attendance.attendance.service;

import HRMS.hrms.attendance.attendance.dto.attendanceRequestDto;
import HRMS.hrms.attendance.attendance.dto.attendanceResponseDto;

import java.util.List;

public interface attendanceService {

    attendanceResponseDto createAttendance(attendanceRequestDto dto);

    attendanceResponseDto updateAttendance(
            Long attendance_Id,
            attendanceRequestDto dto
    );

    attendanceResponseDto getAttendanceById(Long attendance_Id);

    List<attendanceResponseDto> getAllAttendance();

    void deleteAttendance(Long attendance_Id);
}
