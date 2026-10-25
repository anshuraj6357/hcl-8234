
package HRMS.hrms.organisation.department;

import HRMS.hrms.organisation.department.exception.departmentNotCreatedException;
import HRMS.hrms.organisation.department.exception.departmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalException {

    @ExceptionHandler(departmentNotFoundException.class)
    public ResponseEntity<String> globalDepartmentNotFound(
            departmentNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(departmentNotCreatedException.class)
    public ResponseEntity<String> globalDepartmentNotFound(
            departmentNotCreatedException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}
