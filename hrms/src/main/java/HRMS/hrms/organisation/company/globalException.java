package HRMS.hrms.organisation.company;


import HRMS.hrms.organisation.company.exception.companyNotCreatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalException {

    @ExceptionHandler(companyNotCreatedException.class)
    public ResponseEntity<String> globalcomapnyNotCreatedException(companyNotCreatedException ex){

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
}
