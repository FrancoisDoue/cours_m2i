package com.example.aop_exercice1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    @Pointcut("@annotation(com.example.aop_exercice1.annotation.Performance)")
    public void pointcut() {}

    @Around("pointcut()")
    public Object getLatency(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        Object response = joinPoint.proceed();
        System.out.println(joinPoint.getSignature().getName() + " | " + (System.nanoTime() - startTime)+ " ns");
        return response;
    }

}
