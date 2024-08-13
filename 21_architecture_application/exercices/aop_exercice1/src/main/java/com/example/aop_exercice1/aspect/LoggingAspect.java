package com.example.aop_exercice1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("@annotation(com.example.aop_exercice1.annotation.Logger)")
    private void pointcut() {}

    @After("pointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " | args : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println(result);
    }

}
