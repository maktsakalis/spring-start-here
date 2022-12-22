package org.springstarthere.aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springstarthere.model.Comment;

@Aspect
public class LoggingAspectWithoutAnnotation {

  Logger logger = Logger.getLogger(LoggingAspectWithoutAnnotation.class.getName());

  @Around("execution(* org.springstarthere.services.*.*(..))")
  public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

    logger.info("Method will be executed with parameter " + Arrays.asList(joinPoint.getArgs()));

    Comment comment = new Comment();
    comment.setAuthor("Kwstas");
    comment.setText("Kwstas's point");

    Object[] args = {comment};
    Object returnedByMethod = joinPoint.proceed(args);

    logger.info("Method executed and returned " + returnedByMethod);

    return "FAILURE";
  }
}
