
package HRMS.hrms.attendance.lateEarly.service;

import HRMS.hrms.attendance.lateEarly.dto.lateEarlyRequestDto;
import HRMS.hrms.attendance.lateEarly.dto.lateEarlyResponseDto;
import HRMS.hrms.attendance.lateEarly.mapper.lateEarlyToEntityMapper;
import HRMS.hrms.attendance.lateEarly.mapper.lateEarlyToUpdateMapper;
import HRMS.hrms.attendance.lateEarly.mapper.lateEarlyToDtoMapper;
import HRMS.hrms.attendance.lateEarly.model.lateEarlyModel;
import HRMS.hrms.attendance.lateEarly.repository.lateEarlyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class lateEarlyServiceImpl implements lateEarlyService {

    @Autowired
    private  lateEarlyRepository repository;
    private  lateEarlyToEntityMapper entityMapper;
    private  lateEarlyToUpdateMapper updateMapper;
    private  lateEarlyToDtoMapper dtoMapper;



    private void calculateLateEarly(lateEarlyModel model) {

        if (model.getCheckInTime() != null
                && model.getShiftStartTime() != null) {

            long minutes = Duration.between(
                    model.getShiftStartTime(),
                    model.getCheckInTime()
            ).toMinutes();

            model.setLate(minutes > 0);
            model.setLateMinutes(Math.max(0, minutes));

        } else {
            model.setLate(false);
            model.setLateMinutes(0);
        }

        if (model.getCheckOutTime() != null
                && model.getShiftEndTime() != null) {

            long minutes = Duration.between(
                    model.getCheckOutTime(),
                    model.getShiftEndTime()
            ).toMinutes();

            model.setEarly(minutes > 0);
            model.setEarlyMinutes(Math.max(0, minutes));

        } else {
            model.setEarly(false);
            model.setEarlyMinutes(0);
        }
    }

    @Override
    public lateEarlyResponseDto create(lateEarlyRequestDto dto) {

        lateEarlyModel model = entityMapper.toEntity(dto);

        calculateLateEarly(model);

        lateEarlyModel savedModel = repository.save(model);

        return dtoMapper.toDto(savedModel);
    }

    @Override
    public lateEarlyResponseDto getById(Long id) {

        lateEarlyModel model = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Record not found: " + id));

        return dtoMapper.toDto(model);
    }

    @Override
    public List<lateEarlyResponseDto> getAll() {

        return repository.findAll()
                .stream()
                .map(dtoMapper::toDto)
                .toList();
    }

    @Override
    public lateEarlyResponseDto update(
            Long id, lateEarlyRequestDto dto) {

        lateEarlyModel model = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Record not found: " + id));

        updateMapper.updateEntity(model, dto);

        calculateLateEarly(model);

        lateEarlyModel updatedModel = repository.save(model);

        return dtoMapper.toDto(updatedModel);
    }

    @Override
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Record not found: " + id);
        }

        repository.deleteById(id);
    }
}
