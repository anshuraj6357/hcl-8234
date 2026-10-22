
package HRMS.hrms.exception;

import HRMS.hrms.exception.user.userNotCreated;
import HRMS.hrms.exception.user.userNotFOundException;
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
            userNotFOundException ex){

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

}
