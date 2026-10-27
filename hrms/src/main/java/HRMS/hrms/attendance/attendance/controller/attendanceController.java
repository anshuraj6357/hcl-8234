
package HRMS.hrms.attendance.attendance.controller;

import HRMS.hrms.attendance.attendance.dto.attendanceRequestDto;
import HRMS.hrms.attendance.attendance.dto.attendanceResponseDto;
import HRMS.hrms.attendance.attendance.service.attendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class attendanceController {

    @Autowired
    private attendanceService attendanceService;

    // 1. Create Attendance
    @PostMapping
    public ResponseEntity<attendanceResponseDto> createAttendance(
            @RequestBody attendanceRequestDto dto) {

        attendanceResponseDto response =
                attendanceService.createAttendance(dto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 2. Update Attendance
    @PutMapping("/{attendance_Id}")
    public ResponseEntity<attendanceResponseDto> updateAttendance(
            @PathVariable Long attendance_Id,
            @RequestBody attendanceRequestDto dto) {

        attendanceResponseDto response =
                attendanceService.updateAttendance(attendance_Id, dto);

        return ResponseEntity.ok(response);
    }

    // 3. Get Attendance By ID
    @GetMapping("/{attendance_Id}")
    public ResponseEntity<attendanceResponseDto> getAttendanceById(
            @PathVariable Long attendance_Id) {

        attendanceResponseDto response =
                attendanceService.getAttendanceById(attendance_Id);

        return ResponseEntity.ok(response);
    }

    // 4. Get All Attendance
    @GetMapping
    public ResponseEntity<List<attendanceResponseDto>> getAllAttendance() {

        List<attendanceResponseDto> response =
                attendanceService.getAllAttendance();

        return ResponseEntity.ok(response);
    }

    // 5. Delete Attendance
    @DeleteMapping("/{attendance_Id}")
    public ResponseEntity<Void> deleteAttendance(
            @PathVariable Long attendance_Id) {

        attendanceService.deleteAttendance(attendance_Id);

        return ResponseEntity.noContent().build();
    }
}
