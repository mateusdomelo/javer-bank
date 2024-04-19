package io.github.mateusdomelo.javer.rest.controller;

import feign.FeignException;
import io.github.mateusdomelo.javer.exception.ClienteNotFoundException;
import io.github.mateusdomelo.javer.rest.ApiFieldErrors;
import io.github.mateusdomelo.javer.rest.RequestErrors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ClienteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RequestErrors handleClienteNotFoundException(ClienteNotFoundException ex) {
        return new RequestErrors(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiFieldErrors handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ) {
        return new ApiFieldErrors(
                ex.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .map(ObjectError::getDefaultMessage)
                        .toList()
        );
    }

    @ExceptionHandler(FeignException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public RequestErrors handleAnyFeignExceptions(FeignException ex) {
        return new RequestErrors(ex.getMessage());
    }
}
