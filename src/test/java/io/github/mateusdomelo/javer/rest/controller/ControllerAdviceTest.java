package io.github.mateusdomelo.javer.rest.controller;

import feign.FeignException;
import io.github.mateusdomelo.javer.exception.ClienteNotFoundException;
import io.github.mateusdomelo.javer.rest.ApiFieldErrors;
import io.github.mateusdomelo.javer.rest.RequestErrors;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ControllerAdviceTest {
    @Autowired
    private ControllerAdvice controllerAdvice;

    @Test
    void handleClienteNotFoundException_ShouldReturnRequestErrors() {
        /* Setup */
        ClienteNotFoundException exception = new ClienteNotFoundException(1L);
        String exceptionMsg = "Cliente não encontrado com o ID '1'";

        /* Actions */
        RequestErrors result = controllerAdvice.handleClienteNotFoundException(exception);

        /* Verifications */
        assertInstanceOf(RequestErrors.class, result);
        assertEquals(exceptionMsg, result.getResponseMessage());
    }

    @Test
    void handleMethodArgumentNotValidException_ShouldReturnApiFieldErrors() {
        String errorMessage = "Some field validation error message";
        ObjectError error = new ObjectError("validationError", errorMessage);
        BindingResult bindingResult = new BeanPropertyBindingResult(null, "test");
        bindingResult.addError(error);
        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(
                null,
                bindingResult
        );

        ApiFieldErrors result = controllerAdvice.handleMethodArgumentNotValidException(exception);

        assertInstanceOf(ApiFieldErrors.class, result);
        assertEquals(1, result.errors().size());
        assertEquals(errorMessage, result.errors().get(0));
    }

    @Test
    void handleAnyFeignExceptions_ShouldReturnRequestErrors() {
        FeignException feignExceptionMock = Mockito.mock(FeignException.class);
        RequestErrors result = controllerAdvice.handleAnyFeignExceptions(feignExceptionMock);

        assertInstanceOf(RequestErrors.class, result);
    }
}