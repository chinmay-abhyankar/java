package com.pm.patientservice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    // Advice to be executed before the methods in the specified package
    // @Before: Indicates that this advice will be executed before the specified join points
    // "execution(* com.actuator.actuator.controllers.*.*(..))": Pointcut expression
    //  - execution: Specifies join points based on method execution
    //  - (* com.actuator.actuator.controllers.*.*(..)): Method signature pattern
    //      - *: Any return type
    //      - com.actuator.actuator.controllers: Package name
    //      - *.*: Any class and any method within the specified package
    //      - (..): Any number of arguments of any type
    @Before("execution(* com.pm.patientservice.controller.*.*(..))")
    public void logBeforeControllerMethods() {
        log.info("Before Advice");
    }

    // Advice to be executed after the methods in the specified package return successfully
    // @AfterReturning: Indicates that this advice will be executed after the method returns successfully
    // pointcut: Pointcut expression specifying the join points
    // returning: The name of the parameter in the advice method that will hold the returned value
    @AfterReturning(pointcut = "execution(* com.pm.patientservice.controller.*.*(..))", returning = "result")
    public void logAfterControllerMethods(Object result) {
        log.info("AfterReturning Advice " + result);
    }

    // Advice to be executed if the methods in the specified package throw an exception
    // @AfterThrowing: Indicates that this advice will be executed if the method throws an exception
    // pointcut: Pointcut expression specifying the join points
    // throwing: The name of the parameter in the advice method that will hold the thrown exception
    @AfterThrowing(pointcut = "execution(* com.pm.patientservice.controller.*.*(..))", throwing = "exception")
    public void logAfterThrowingControllerMethods(Exception exception) {
       log.info("Exception thrown from controller method: " + exception.getMessage());
    }

    // Advice to be executed around the methods in the specified package
    // @Around: Indicates that this advice will be executed around the specified join points
    // The advice method can control when and if the target method is called
    @Around("execution(* com.pm.patientservice.controller.*.*(..))")
    public Object logAroundControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("Method execution start time: " + System.currentTimeMillis());

        // Proceed with the method execution
        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        log.info("Method execution end time: " + System.currentTimeMillis());

        return proceed;
    }
}
