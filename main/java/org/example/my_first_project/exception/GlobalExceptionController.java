package org.example.my_first_project.exception;



import org.example.my_first_project.dto.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {


    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<?> error(Exception e) {
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                MessageResponse.error(e.getMessage())
        );
    }


    @ExceptionHandler(AlreadyExistsException.class)
    private ResponseEntity<?> already(Exception e) {
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(
                MessageResponse.error(e.getMessage())
        );
    }

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<?> notFound(Exception e) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                MessageResponse.error(e.getMessage())
        );
    }
}
