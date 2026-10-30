
package HRMS.hrms.attendance.attendance.service;

import HRMS.hrms.attendance.attendance.dto.attendanceRequestDto;
import HRMS.hrms.attendance.attendance.dto.attendanceResponseDto;
import HRMS.hrms.attendance.attendance.mapper.attendanceToDtoMapper;
import HRMS.hrms.attendance.attendance.mapper.attendanceToEntityMapper;
import HRMS.hrms.attendance.attendance.mapper.attendanceToUpdateMapper;
import HRMS.hrms.attendance.attendance.model.attendanceModel;
import HRMS.hrms.attendance.attendance.repository.attendanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class attendanceServiceImpl implements attendanceService {

    @Autowired
    private  attendanceRepository attendanceRepository;
    @Autowired
    private  attendanceToEntityMapper entityMapper;
    @Autowired
    private  attendanceToDtoMapper dtoMapper;
    @Autowired
    private  attendanceToUpdateMapper updateMapper;



    @Override
    public attendanceResponseDto createAttendance(attendanceRequestDto dto) {
        attendanceModel model = entityMapper.toEntity(dto);
        attendanceModel savedModel = attendanceRepository.save(model);
        return dtoMapper.toDto(savedModel);
    }

    @Override
    public attendanceResponseDto updateAttendance(
            Long attendance_Id,
            attendanceRequestDto dto
    ) {
        attendanceModel model = attendanceRepository.findById(attendance_Id)
                .orElseThrow(() ->
                        new RuntimeException("Attendance not found: " + attendance_Id));

        updateMapper.updateEntity(model, dto);

        attendanceModel updatedModel = attendanceRepository.save(model);
        return dtoMapper.toDto(updatedModel);
    }

    @Override
    public attendanceResponseDto getAttendanceById(Long attendance_Id) {
        attendanceModel model = attendanceRepository.findById(attendance_Id)
                .orElseThrow(() ->
                        new RuntimeException("Attendance not found: " + attendance_Id));

        return dtoMapper.toDto(model);
    }

    @Override
    public List<attendanceResponseDto> getAllAttendance() {
        return attendanceRepository.findAll()
                .stream()
                .map(dtoMapper::toDto)
                .toList();
    }

    @Override
    public void deleteAttendance(Long attendance_Id) {
        attendanceModel model = attendanceRepository.findById(attendance_Id)
                .orElseThrow(() ->
                        new RuntimeException("Attendance not found: " + attendance_Id));

        attendanceRepository.delete(model);
    }
}
