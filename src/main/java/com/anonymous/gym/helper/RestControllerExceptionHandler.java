package com.anonymous.gym.helper;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestControllerExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleInValidArgumentException(MethodArgumentNotValidException ex) {
        Map<String, String> errorResponse = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    errorResponse.put(error.getField(), error.getDefaultMessage());
                });

        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> entityNotFoundExceptionHandler(EntityNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

//    @ExceptionHandler(TransactionSystemException.class)
//    public ResponseEntity<Map<String, String>> handleTransactionSystemException(TransactionSystemException ex) {
//        Map<String, String> errorResponse = new HashMap<>();
//
//       errorResponse.put("message", ex.getMessage());
//
//        return ResponseEntity.badRequest().body(errorResponse);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
//        Map<String, String> response = new HashMap<>();
//        response.put("message", ex.getLocalizedMessage());
//        ex.printStackTrace();
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//    }

}
