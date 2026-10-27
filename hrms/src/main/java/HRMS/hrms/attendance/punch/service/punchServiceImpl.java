package HRMS.hrms.attendance.punch.service;

import HRMS.hrms.attendance.punch.dto.punchRequestDto;
import HRMS.hrms.attendance.punch.dto.punchResponseDto;
import HRMS.hrms.attendance.punch.exception.punchException;
import HRMS.hrms.attendance.punch.mapper.punchToEntityMapper;
import HRMS.hrms.attendance.punch.mapper.punchToUpdateMapper;
import HRMS.hrms.attendance.punch.mapper.punchToDtoMapper;
import HRMS.hrms.attendance.punch.model.punchModel;
import HRMS.hrms.attendance.punch.repository.punchRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class punchServiceImpl implements punchService {
    private final punchRepository repository;
    private final punchToEntityMapper entityMapper;
    private final punchToUpdateMapper updateMapper;
    private final punchToDtoMapper dtoMapper;

    public punchServiceImpl(punchRepository r, punchToEntityMapper e,
            punchToUpdateMapper u, punchToDtoMapper d) {
        repository = r; entityMapper = e; updateMapper = u; dtoMapper = d;
    }

    private void validate(punchRequestDto dto) {
        if (dto.getEmployeeId() == null || dto.getPunchTime() == null || dto.getPunchType() == null)
            throw new punchException("employeeId, punchTime and punchType are required");
        String type = dto.getPunchType().trim().toUpperCase();
        if (!type.equals("IN") && !type.equals("OUT"))
            throw new punchException("punchType must be IN or OUT");
    }

//    @Override public punchResponseDto create(punchRequestDto dto) {
//        validate(dto);
//        return dtoMapper.toDto(repository.save(entityMapper.toEntity(dto)));
//    }
    @Override public punchResponseDto getById(Long id) {
        return dtoMapper.toDto(repository.findById(id).orElseThrow(() -> new punchException("Punch not found: " + id)));
    }
    @Override public List<punchResponseDto> getAll() {
        return repository.findAll().stream().map(dtoMapper::toDto).toList();
    }
    @Override public List<punchResponseDto> getByEmployee(Long employeeId) {
        return repository.findByEmployeeIdOrderByPunchTimeDesc(employeeId).stream().map(dtoMapper::toDto).toList();
    }
    @Override public punchResponseDto update(Long id, punchRequestDto dto) {
        punchModel m = repository.findById(id).orElseThrow(() -> new punchException("Punch not found: " + id));
        if (dto.getPunchType() != null && !dto.getPunchType().trim().equalsIgnoreCase("IN")
                && !dto.getPunchType().trim().equalsIgnoreCase("OUT"))
            throw new punchException("punchType must be IN or OUT");
        updateMapper.updateEntity(m, dto);
        return dtoMapper.toDto(repository.save(m));
    }
    @Override public void delete(Long id) {
        if (!repository.existsById(id)) throw new punchException("Punch not found: " + id);
        repository.deleteById(id);
    }
}
