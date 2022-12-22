package org.springstarthere.aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class SecurityAspect {

    Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    @Around("@annotation(org.springstarthere.annotations.ToLog)")
    public String secure(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info("SecurityAspect: Method will be executed with parameter " + Arrays.asList(joinPoint.getArgs()));

        Object returnedByMethod = joinPoint.proceed();

        logger.info("SecurityAspect: Method executed and returned " + returnedByMethod);

        return returnedByMethod.toString();
    }
}
