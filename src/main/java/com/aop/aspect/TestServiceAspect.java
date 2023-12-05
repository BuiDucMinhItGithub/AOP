package com.aop.aspect;


import com.aop.service.FakeService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TestServiceAspect {


  private Logger logger = LoggerFactory.getLogger(TestServiceAspect.class);
  private static final String oke = "minh";

  @Before("execution(* com.aop.service.FakeService.callDaoSuccess(..))")
  public void before(JoinPoint joinPoint) {
    logger.info(" before called " + joinPoint.toString());
  }

  @After("execution(* com.aop.service.FakeService.callDaoSuccess(..))")
  public void after(JoinPoint joinPoint) {
    logger.info(" after called " + joinPoint.toString());
  }

  @AfterReturning("execution(* com.aop.service.FakeService.callDaoSuccess(..))")
  public void afterReturning(JoinPoint joinPoint) {
    logger.info(" afterReturning called " + joinPoint.toString());
  }

  @AfterThrowing(pointcut = "execution(* com.aop.service.FakeService.callDaoFailed(..))", throwing = oke)
  public void afterThrowing(JoinPoint joinPoint) {
    logger.info(" afterThrowing called " + joinPoint.toString());
  }

  @Around("execution(* com.aop.service.FakeService.*(..))")
  public void around(ProceedingJoinPoint joinPoint) throws Throwable {

    Long startTime = System.currentTimeMillis();
    logger.info("Start Time Taken by {} is {}", joinPoint, startTime);
    joinPoint.proceed();

    Long timeTaken = System.currentTimeMillis() - startTime;
    logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
  }

  @Around("@annotation(com.aop.aspect.TrackTime)")
  public void aroundTrackTime(ProceedingJoinPoint joinPoint) throws Throwable {

    Long startTime = System.currentTimeMillis();
    logger.info("Start Time Taken by {} is {}", joinPoint, startTime);
    joinPoint.proceed();

    Long timeTaken = System.currentTimeMillis() - startTime;
    logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
  }

}
