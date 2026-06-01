package co.istad.longfou.restapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
@Slf4j
public class AppException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationEception(MethodArgumentNotValidException e){

        log.error("Validation Eception happpened");

        List<Map<String, String>> errors = new ArrayList<>();

        e.getBindingResult()
                .getFieldErrors()
                .forEach(error -> {

                    Map<String, String> fieldError = new HashMap<>();

                    fieldError.put("field", error.getField());
                    fieldError.put("message", error.getDefaultMessage());

                    errors.add(fieldError);
                });

        Map<String, Object> response = new HashMap<>();
        response.put("status", false);
        response.put("code", 400);
        response.put("messsage", "Validation Failed");
        response.put("errors", errors);
//        response.put("errors", "price is required");

        return ResponseEntity
                .badRequest()
                .body(response);
    }
}
