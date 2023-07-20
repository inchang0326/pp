package com.example.pp.handler;

import com.example.pp.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = NoSuchElementException.class)
    public Response NoSuchElementExceptionErrorHandler(Exception e) {

        log.error(e.getMessage(), e);
        final Response response = new Response();
        response.setStatus("CB2000");
        response.setMessage("UNKNOWN ELEMENT ERROR");
        return response;
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ArithmeticException.class)
    public Response ArithmeticErrorHandler(ArithmeticException e) {

        log.error(e.getMessage(), e);
        final Response response = new Response();
        response.setStatus("CB1000");
        response.setMessage("UNKNOWN SERVER ERROR");
        return response;
    }
}
