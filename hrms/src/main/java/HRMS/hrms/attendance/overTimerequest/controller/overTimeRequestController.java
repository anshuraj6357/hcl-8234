package HRMS.hrms.attendance.overTimerequest.controller;

import HRMS.hrms.attendance.overTimerequest.dto.overTimeRequestDto;
import HRMS.hrms.attendance.overTimerequest.dto.overTimeResponseDto;
import HRMS.hrms.attendance.overTimerequest.service.overTimeRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/overtime-requests")
public class overTimeRequestController {
    private final overTimeRequestService service;
    public overTimeRequestController(overTimeRequestService service) { this.service = service; }

    @PostMapping public ResponseEntity<overTimeResponseDto> create(@RequestBody overTimeRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }
    @GetMapping public ResponseEntity<List<overTimeResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}") public ResponseEntity<overTimeResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/employee/{employeeId}") public ResponseEntity<List<overTimeResponseDto>> getByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getByEmployee(employeeId));
    }
    @PutMapping("/{id}") public ResponseEntity<overTimeResponseDto> update(@PathVariable Long id, @RequestBody overTimeRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
    @PatchMapping("/{id}/review")
    public ResponseEntity<overTimeResponseDto> review(@PathVariable Long id, @RequestBody Map<String, Object> body) {
        Long reviewerId = body.get("reviewerId") == null ? null : Long.valueOf(body.get("reviewerId").toString());
        String status = body.get("status") == null ? null : body.get("status").toString();
        String remarks = body.get("remarks") == null ? null : body.get("remarks").toString();
        return ResponseEntity.ok(service.review(id, reviewerId, status, remarks));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id); return ResponseEntity.noContent().build();
    }
}
