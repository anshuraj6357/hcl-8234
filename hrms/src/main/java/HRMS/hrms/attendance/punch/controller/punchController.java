package HRMS.hrms.attendance.punch.controller;

import HRMS.hrms.attendance.punch.dto.punchRequestDto;
import HRMS.hrms.attendance.punch.dto.punchResponseDto;
import HRMS.hrms.attendance.punch.service.punchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/punches")
public class punchController {
    private final punchService service;
    public punchController(punchService service) { this.service = service; }

//    @PostMapping public ResponseEntity<punchResponseDto> create(@RequestBody punchRequestDto dto) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
//    }
    @GetMapping public ResponseEntity<List<punchResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}") public ResponseEntity<punchResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/employee/{employeeId}") public ResponseEntity<List<punchResponseDto>> getByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getByEmployee(employeeId));
    }
    @PutMapping("/{id}") public ResponseEntity<punchResponseDto> update(@PathVariable Long id, @RequestBody punchRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id); return ResponseEntity.noContent().build();
    }
}
