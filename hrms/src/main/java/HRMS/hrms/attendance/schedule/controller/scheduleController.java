package HRMS.hrms.attendance.schedule.controller;

import HRMS.hrms.attendance.schedule.dto.scheduleRequestDto;
import HRMS.hrms.attendance.schedule.dto.scheduleResponseDto;
import HRMS.hrms.attendance.schedule.service.scheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class scheduleController {
    private final scheduleService service;
    public scheduleController(scheduleService service) { this.service = service; }

    @PostMapping public ResponseEntity<scheduleResponseDto> create(@RequestBody scheduleRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }
    @GetMapping public ResponseEntity<List<scheduleResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}") public ResponseEntity<scheduleResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/employee/{employeeId}") public ResponseEntity<List<scheduleResponseDto>> getByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getByEmployee(employeeId));
    }
    @GetMapping("/date/{date}") public ResponseEntity<List<scheduleResponseDto>> getByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(service.getByDate(date));
    }
    @PutMapping("/{id}") public ResponseEntity<scheduleResponseDto> update(@PathVariable Long id, @RequestBody scheduleRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id); return ResponseEntity.noContent().build();
    }
}
