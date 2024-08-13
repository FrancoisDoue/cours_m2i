package com.example.aop_exercice2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Notification {

    @Pointcut(value = "@annotation(com.example.aop_exercice2.annotation.AllowNotification)")
    public void notification() {
    }

    @Before("notification()")
    public void beforeNotify(JoinPoint joinPoint) {
        System.out.println(joinPoint.getStaticPart());
        System.out.println(joinPoint.getSignature().getName());
    }

}
