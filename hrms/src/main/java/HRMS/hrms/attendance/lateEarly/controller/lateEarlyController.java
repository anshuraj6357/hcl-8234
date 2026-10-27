
package HRMS.hrms.attendance.lateEarly.controller;

import HRMS.hrms.attendance.lateEarly.dto.lateEarlyRequestDto;
import HRMS.hrms.attendance.lateEarly.dto.lateEarlyResponseDto;
import HRMS.hrms.attendance.lateEarly.service.lateEarlyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/late-early")
public class lateEarlyController {

    private final lateEarlyService lateEarlyService;

    public lateEarlyController(lateEarlyService lateEarlyService) {
        this.lateEarlyService = lateEarlyService;
    }

    // 1. Create Late/Early Record
    @PostMapping
    public ResponseEntity<lateEarlyResponseDto> create(
            @RequestBody lateEarlyRequestDto dto) {

        lateEarlyResponseDto response = lateEarlyService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 2. Get All Records
    @GetMapping
    public ResponseEntity<List<lateEarlyResponseDto>> getAll() {

        return ResponseEntity.ok(lateEarlyService.getAll());
    }

    // 3. Get Record By ID
    @GetMapping("/{id}")
    public ResponseEntity<lateEarlyResponseDto> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(lateEarlyService.getById(id));
    }

    // 4. Update Record
    @PutMapping("/{id}")
    public ResponseEntity<lateEarlyResponseDto> update(
            @PathVariable Long id,
            @RequestBody lateEarlyRequestDto dto) {

        return ResponseEntity.ok(lateEarlyService.update(id, dto));
    }

    // 5. Delete Record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        lateEarlyService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
