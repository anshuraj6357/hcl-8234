package HRMS.hrms.attendance.schedule.service;

import HRMS.hrms.attendance.schedule.dto.scheduleRequestDto;
import HRMS.hrms.attendance.schedule.dto.scheduleResponseDto;
import HRMS.hrms.attendance.schedule.exception.scheduleException;
import HRMS.hrms.attendance.schedule.mapper.scheduleToEntityMapper;
import HRMS.hrms.attendance.schedule.mapper.scheduleToUpdateMapper;
import HRMS.hrms.attendance.schedule.mapper.scheduleToDtoMapper;
import HRMS.hrms.attendance.schedule.model.scheduleModel;
import HRMS.hrms.attendance.schedule.repository.scheduleRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class scheduleServiceImpl implements scheduleService {
    private final scheduleRepository repository;
    private final scheduleToEntityMapper entityMapper;
    private final scheduleToUpdateMapper updateMapper;
    private final scheduleToDtoMapper dtoMapper;

    public scheduleServiceImpl(scheduleRepository r, scheduleToEntityMapper e,
            scheduleToUpdateMapper u, scheduleToDtoMapper d) {
        repository = r; entityMapper = e; updateMapper = u; dtoMapper = d;
    }

    private void validate(scheduleRequestDto dto) {
        if (dto.getEmployeeId() == null || dto.getShiftId() == null || dto.getScheduleDate() == null)
            throw new scheduleException("employeeId, shiftId and scheduleDate are required");
    }

    @Override public scheduleResponseDto create(scheduleRequestDto dto) {
        validate(dto);
        if (repository.existsByEmployeeIdAndScheduleDate(dto.getEmployeeId(), dto.getScheduleDate()))
            throw new scheduleException("A schedule already exists for this employee and date");
        return dtoMapper.toDto(repository.save(entityMapper.toEntity(dto)));
    }
    @Override public scheduleResponseDto getById(Long id) {
        return dtoMapper.toDto(repository.findById(id).orElseThrow(() -> new scheduleException("Schedule not found: " + id)));
    }
    @Override public List<scheduleResponseDto> getAll() {
        return repository.findAll().stream().map(dtoMapper::toDto).toList();
    }
    @Override public List<scheduleResponseDto> getByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId).stream().map(dtoMapper::toDto).toList();
    }
    @Override public List<scheduleResponseDto> getByDate(LocalDate date) {
        return repository.findByScheduleDate(date).stream().map(dtoMapper::toDto).toList();
    }
    @Override public scheduleResponseDto update(Long id, scheduleRequestDto dto) {
        scheduleModel m = repository.findById(id).orElseThrow(() -> new scheduleException("Schedule not found: " + id));
        updateMapper.updateEntity(m, dto);
        return dtoMapper.toDto(repository.save(m));
    }
    @Override public void delete(Long id) {
        if (!repository.existsById(id)) throw new scheduleException("Schedule not found: " + id);
        repository.deleteById(id);
    }
}
