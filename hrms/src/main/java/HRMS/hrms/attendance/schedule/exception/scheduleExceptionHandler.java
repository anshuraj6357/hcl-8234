package HRMS.hrms.attendance.schedule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;

@RestControllerAdvice
public class scheduleExceptionHandler {
    @ExceptionHandler(scheduleException.class)
    public ResponseEntity<Map<String, Object>> handle(scheduleException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "status", 400,
            "error", "Bad Request",
            "message", ex.getMessage()
        ));
    }
}
