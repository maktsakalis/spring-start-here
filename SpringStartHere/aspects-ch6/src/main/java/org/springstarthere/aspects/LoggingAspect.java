package org.springstarthere.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(2)
public class LoggingAspect {

    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(org.springstarthere.annotations.ToLog)")
    public String log(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info("LoggingAspect: Method will be executed with parameter " + Arrays.asList(joinPoint.getArgs()));

        Object returnedByMethod = joinPoint.proceed();

        logger.info("LoggingAspect: Method executed and returned " + returnedByMethod);

        return returnedByMethod.toString();
    }
}
