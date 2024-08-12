package com.example.aop_exercice1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @After("execution(* com.example.aop_exercice1.service.BookService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " | args : " + Arrays.toString(joinPoint.getArgs()));
    }
}
