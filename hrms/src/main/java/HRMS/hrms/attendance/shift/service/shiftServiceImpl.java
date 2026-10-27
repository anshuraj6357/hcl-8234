package HRMS.hrms.attendance.shift.service;

import HRMS.hrms.attendance.shift.dto.shiftRequestDto;
import HRMS.hrms.attendance.shift.dto.shiftResponseDto;
import HRMS.hrms.attendance.shift.exception.shiftException;
import HRMS.hrms.attendance.shift.mapper.shiftToEntityMapper;
import HRMS.hrms.attendance.shift.mapper.shiftToUpdateMapper;
import HRMS.hrms.attendance.shift.mapper.shiftToDtoMapper;
import HRMS.hrms.attendance.shift.model.shiftModel;
import HRMS.hrms.attendance.shift.repository.shiftRepository;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class shiftServiceImpl implements shiftService {
    private final shiftRepository repository;
    private final shiftToEntityMapper entityMapper;
    private final shiftToUpdateMapper updateMapper;
    private final shiftToDtoMapper dtoMapper;

    public shiftServiceImpl(shiftRepository repository, shiftToEntityMapper entityMapper,
            shiftToUpdateMapper updateMapper, shiftToDtoMapper dtoMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
        this.updateMapper = updateMapper;
        this.dtoMapper = dtoMapper;
    }

    private void validateTimes(String start, String end) {
        try {
            LocalTime.parse(start);
            LocalTime.parse(end);
        } catch (DateTimeParseException | NullPointerException ex) {
            throw new shiftException("startTime/endTime must be valid HH:mm or HH:mm:ss values");
        }
    }

    @Override public shiftResponseDto create(shiftRequestDto dto) {
        validateTimes(dto.getStartTime(), dto.getEndTime());
        if (dto.getShiftName() == null || dto.getShiftName().isBlank())
            throw new shiftException("shiftName is required");
        if (dto.getGraceMinutes() != null && dto.getGraceMinutes() < 0)
            throw new shiftException("graceMinutes cannot be negative");
        if (repository.existsByShiftNameIgnoreCase(dto.getShiftName()))
            throw new shiftException("Shift name already exists: " + dto.getShiftName());
        return dtoMapper.toDto(repository.save(entityMapper.toEntity(dto)));
    }

    @Override public shiftResponseDto getById(Long id) {
        return dtoMapper.toDto(repository.findById(id)
            .orElseThrow(() -> new shiftException("Shift not found: " + id)));
    }

    @Override public List<shiftResponseDto> getAll() {
        return repository.findAll().stream().map(dtoMapper::toDto).toList();
    }

    @Override public shiftResponseDto update(Long id, shiftRequestDto dto) {
        shiftModel model = repository.findById(id)
            .orElseThrow(() -> new shiftException("Shift not found: " + id));
        if (dto.getStartTime() != null) LocalTime.parse(dto.getStartTime());
        if (dto.getEndTime() != null) LocalTime.parse(dto.getEndTime());
        updateMapper.updateEntity(model, dto);
        return dtoMapper.toDto(repository.save(model));
    }

    @Override public void delete(Long id) {
        if (!repository.existsById(id)) throw new shiftException("Shift not found: " + id);
        repository.deleteById(id);
    }
}
