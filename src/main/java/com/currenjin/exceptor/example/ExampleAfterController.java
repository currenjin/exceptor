package com.currenjin.exceptor.example;

import com.currenjin.exceptor.core.Exceptor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Exceptor(status = HttpStatus.BAD_REQUEST, exception = IllegalArgumentException.class)
public class ExampleAfterController {
    @GetMapping("/example/after")
    ResponseEntity<String> request() {
        throw new IllegalArgumentException("test");
    }
}
