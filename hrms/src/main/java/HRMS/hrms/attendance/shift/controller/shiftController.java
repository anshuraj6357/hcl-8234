package HRMS.hrms.attendance.shift.controller;

import HRMS.hrms.attendance.shift.dto.shiftRequestDto;
import HRMS.hrms.attendance.shift.dto.shiftResponseDto;
import HRMS.hrms.attendance.shift.service.shiftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class shiftController {
    private final shiftService service;
    public shiftController(shiftService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<shiftResponseDto> create(@RequestBody shiftRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }
    @GetMapping
    public ResponseEntity<List<shiftResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<shiftResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<shiftResponseDto> update(@PathVariable Long id, @RequestBody shiftRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
