package com.poc.calculator.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poc.calculator.trace.TracerAPIAdapter;

@Aspect
@Component
public class TraceAspect {
	
	@Autowired
	private TracerAPIAdapter traceApi;
	
	@Before("execution(* com.poc.calculator.controller.CalculatorController.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getClass());
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Entering method " + methodName + " with arguments " + Arrays.deepToString(args));
    }
	
	@AfterReturning(pointcut= "execution(* com.poc.calculator.controller.CalculatorController.*(..))", returning="result")
	public void logMethodExitAndTraceResult(JoinPoint joinPoint, Object result) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getClass());
		
		String methodName = joinPoint.getSignature().getName();
        logger.info("Exiting method " + methodName + " with result " + result);
        traceApi.trace(result);
	}
}
