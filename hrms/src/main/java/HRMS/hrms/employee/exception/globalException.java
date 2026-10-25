
package HRMS.hrms.employee.exception;

import HRMS.hrms.employee.exception.employee.employeeNotFound;
import HRMS.hrms.employee.exception.leave.leaveNotGranted;
import HRMS.hrms.auth.exception.userNotCreated;
import HRMS.hrms.auth.exception.userNotFOundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalException {

    @ExceptionHandler(employeeNotFound.class)
    public ResponseEntity<String> handleEmployeeNotFound(
            employeeNotFound ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
    @ExceptionHandler(userNotFOundException.class)
    public ResponseEntity<String> handleUserNotFound(
            userNotFOundException ex){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(userNotCreated.class)
    public ResponseEntity<String> handleUserNotCreated(
            userNotCreated ex){

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
    @ExceptionHandler(leaveNotGranted.class)

    public ResponseEntity<String> handleLeaveNotGranted(
            leaveNotGranted ex
    ){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());

    }
}
