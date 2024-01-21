package com.currenjin.exceptor.core;

import org.springframework.http.HttpStatus;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Exceptor {
    HttpStatus status();
    Class<? extends Throwable> exception();
}
