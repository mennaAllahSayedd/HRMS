package com.example.UserService.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j

public class LoggerAspect {

    @Pointcut("execution(* com.example.UserService.Services.EmployeeService.*(..))")
    public void employeeServiceMehtod(){}

    @AfterReturning(pointcut = "employeeServiceMehtod()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("After method: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "employeeServiceMehtod()", throwing = "ex")
    public void logError(JoinPoint jp, Exception ex) {
        log.error(" Error in: " + jp.getSignature() + " → " + ex.getMessage());
    }
}
