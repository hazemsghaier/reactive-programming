package org.hazem.reactive.databaseintegration.controller;

import org.hazem.reactive.databaseintegration.dto.reponse.ErrorResponse;
import org.hazem.reactive.databaseintegration.exeptions.ConflictExeception;
import org.hazem.reactive.databaseintegration.exeptions.DataAccessException;
import org.hazem.reactive.databaseintegration.exeptions.RessourceNotFoundExeception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RessourceNotFoundExeception.class)
    public Mono<ResponseEntity<ErrorResponse>> handleNotFound(RessourceNotFoundExeception ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), ex.getMessage(),HttpStatus.NOT_FOUND.value());
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(error));
    }

    @ExceptionHandler(DataAccessException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleDatabase(DataAccessException ex) {
        ErrorResponse error = new ErrorResponse("",ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error));
    }
    @ExceptionHandler(WebExchangeBindException.class) // Pour les erreurs de validation (DTO @Valid)
    public Mono<ResponseEntity<ErrorResponse>> handleValidation(WebExchangeBindException ex) {
        String message = ex.getFieldErrors().stream()
                .map(err -> err.getField() + " " + err.getDefaultMessage())
                .collect(Collectors.joining(", "));
        ErrorResponse error = new ErrorResponse(message,message,HttpStatus.BAD_REQUEST.value());
        return Mono.just(ResponseEntity.badRequest().body(error));
    }
    @ExceptionHandler(ConflictExeception.class)
    public Mono<ResponseEntity<ErrorResponse>> handleConflict(ConflictExeception ex) {
        System.out.println("ex.getMessage()");
        ErrorResponse error = new ErrorResponse(ex.getMessage(),ex.getMessage(),HttpStatus.CONFLICT.value() );
        return Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).body(error));
    }
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ErrorResponse>> handleGeneric(Throwable ex) {
        ErrorResponse error = new ErrorResponse( ex.getMessage(),"laallaalal",(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error));
    }
}
