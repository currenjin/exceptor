package com.currenjin.exceptor.example;

import com.currenjin.exceptor.core.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleBeforeController {
    @GetMapping("/example/before")
    ResponseEntity<String> request() {
        throw new IllegalArgumentException("test");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse onException(IllegalArgumentException e) {
        return ErrorResponse.with(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}
