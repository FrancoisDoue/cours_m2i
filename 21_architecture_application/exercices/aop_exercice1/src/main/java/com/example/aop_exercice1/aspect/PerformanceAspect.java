package com.example.aop_exercice1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    @Around(value = "execution(* com.example.aop_exercice1.service.BookService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object response = joinPoint.proceed();
        System.out.println(joinPoint.getSignature().getName() + " | " + (System.currentTimeMillis() - startTime)+ " ms");
        return response;
    }

}
