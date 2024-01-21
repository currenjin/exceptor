package com.currenjin.exceptor.core;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
class ExceptorProcessor {
    @Around("@within(Exceptor)")
    public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {
        Exceptor exceptionAnnotation = getExceptorAnnotation(joinPoint);

        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            ErrorResponse responseBody = ErrorResponse.with(exceptionAnnotation.status().value(), e.getMessage());
            return ResponseEntity.status(exceptionAnnotation.status()).body(responseBody);
        }
    }

    private Exceptor getExceptorAnnotation(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Class<?> targetClass = methodSignature.getMethod().getDeclaringClass();
        return targetClass.getAnnotation(Exceptor.class);
    }
}
