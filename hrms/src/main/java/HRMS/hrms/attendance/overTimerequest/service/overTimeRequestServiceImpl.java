package HRMS.hrms.attendance.overTimerequest.service;

import HRMS.hrms.attendance.overTimerequest.dto.overTimeRequestDto;
import HRMS.hrms.attendance.overTimerequest.dto.overTimeResponseDto;
import HRMS.hrms.attendance.overTimerequest.exception.overTimeRequestException;
import HRMS.hrms.attendance.overTimerequest.mapper.overTimeRequestToEntityMapper;
import HRMS.hrms.attendance.overTimerequest.mapper.overTimeRequestToUpdateMapper;
import HRMS.hrms.attendance.overTimerequest.mapper.overTimeRequestToDtoMapper;
import HRMS.hrms.attendance.overTimerequest.model.overTimeRequestModel;
import HRMS.hrms.attendance.overTimerequest.repository.overTimeRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class overTimeRequestServiceImpl implements overTimeRequestService {
    private final overTimeRequestRepository repository;
    private final overTimeRequestToEntityMapper entityMapper;
    private final overTimeRequestToUpdateMapper updateMapper;
    private final overTimeRequestToDtoMapper dtoMapper;

    public overTimeRequestServiceImpl(overTimeRequestRepository r, overTimeRequestToEntityMapper e,
            overTimeRequestToUpdateMapper u, overTimeRequestToDtoMapper d) {
        repository = r; entityMapper = e; updateMapper = u; dtoMapper = d;
    }

    private void validate(overTimeRequestDto dto) {
        if (dto.getEmployeeId() == null || dto.getOvertimeDate() == null ||
                dto.getStartTime() == null || dto.getEndTime() == null)
            throw new overTimeRequestException("employeeId, overtimeDate, startTime and endTime are required");
        if (!dto.getEndTime().isAfter(dto.getStartTime()))
            throw new overTimeRequestException("endTime must be after startTime; overnight overtime needs separate handling");
    }

    @Override public overTimeResponseDto create(overTimeRequestDto dto) {
        validate(dto);
        return dtoMapper.toDto(repository.save(entityMapper.toEntity(dto)));
    }
    @Override public overTimeResponseDto getById(Long id) {
        return dtoMapper.toDto(repository.findById(id).orElseThrow(() -> new overTimeRequestException("Overtime request not found: " + id)));
    }
    @Override public List<overTimeResponseDto> getAll() {
        return repository.findAll().stream().map(dtoMapper::toDto).toList();
    }
    @Override public List<overTimeResponseDto> getByEmployee(Long employeeId) {
        return repository.findByEmployeeIdOrderByOvertimeDateDesc(employeeId).stream().map(dtoMapper::toDto).toList();
    }
    @Override public overTimeResponseDto update(Long id, overTimeRequestDto dto) {
        overTimeRequestModel m = repository.findById(id).orElseThrow(() -> new overTimeRequestException("Overtime request not found: " + id));
        if (!"PENDING".equalsIgnoreCase(m.getStatus()))
            throw new overTimeRequestException("Only pending requests can be edited");
        if (dto.getStartTime() != null && dto.getEndTime() != null && !dto.getEndTime().isAfter(dto.getStartTime()))
            throw new overTimeRequestException("endTime must be after startTime");
        updateMapper.updateEntity(m, dto);
        return dtoMapper.toDto(repository.save(m));
    }
    @Override public overTimeResponseDto review(Long id, Long reviewerId, String status, String remarks) {
        overTimeRequestModel m = repository.findById(id).orElseThrow(() -> new overTimeRequestException("Overtime request not found: " + id));
        if (!"APPROVED".equalsIgnoreCase(status) && !"REJECTED".equalsIgnoreCase(status))
            throw new overTimeRequestException("Review status must be APPROVED or REJECTED");
        if (!"PENDING".equalsIgnoreCase(m.getStatus()))
            throw new overTimeRequestException("Only pending requests can be reviewed");
        if (reviewerId == null) throw new overTimeRequestException("reviewerId is required");
        m.setStatus(status.toUpperCase()); m.setReviewedBy(reviewerId); m.setReviewRemarks(remarks);
        return dtoMapper.toDto(repository.save(m));
    }
    @Override public void delete(Long id) {
        if (!repository.existsById(id)) throw new overTimeRequestException("Overtime request not found: " + id);
        repository.deleteById(id);
    }
}
