package hcl_project_1.hcl_project_1.Exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class HandleGlobalException {


    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<Map<String,String>>  HandleStudentNotFound(StudentNotFound ex){

        Map<String,String> response=Map.of(
                "message",ex.getMessage(),
                "status","404"
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


}
