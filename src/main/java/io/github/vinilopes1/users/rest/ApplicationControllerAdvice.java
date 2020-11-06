package io.github.vinilopes1.users.rest;

import io.github.vinilopes1.users.rest.exceptions.APIErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIErrors handleValidationErrors(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages = bindingResult.getAllErrors().stream().
                map(objectError ->  objectError.getDefaultMessage())
                .collect(Collectors.toList());
        return new APIErrors(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusExceptions(ResponseStatusException ex){
        String errorMessage = ex.getMessage();
        HttpStatus statusCode = ex.getStatus();
        APIErrors apiErrors = new APIErrors(errorMessage);
        return new ResponseEntity(apiErrors, statusCode);
    }
}
