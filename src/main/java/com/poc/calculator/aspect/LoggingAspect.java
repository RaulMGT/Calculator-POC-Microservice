package com.poc.calculator.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.poc.calculator.util.Utils;

import io.corp.calculator.TracerAPI;

@Aspect
@Component
public class LoggingAspect {
	
	@Autowired
	private TracerAPI traceApi;
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	/**
	 * Pointcut for all CalculatorController methods
	 */
	@Pointcut("execution(* com.poc.calculator.controller.CalculatorController.*(..))")
    public void controllerMethods() {}
	
	/**
	 * Logs incoming request
	 * 
	 * @param joinPoint points a CalculatorController method
	 */
	@Before("controllerMethods()")
    public void logMethodEntry(JoinPoint joinPoint) {
		HttpServletRequest request = getRequest();
		
		String paramsJson = Utils.convertToJson(request.getParameterMap());
	   
        logger.info("Incoming Request: {} {}, params={}", 
                request.getMethod(), request.getRequestURI(), paramsJson);
    }
	
	/**
	 * Logs the exiting response and traces the result using {@link TracerAPIAdapter}
	 * 
	 * @param joinPoint points a CalculatorController method
	 * @param result value returned by method
	 */
	@AfterReturning(pointcut= "controllerMethods()", returning="result")
	public void logMethodExitAndTraceResult(JoinPoint joinPoint, Object result) {
		HttpServletRequest request = getRequest();
		
		String resultJson = Utils.convertToJson(result);
	    
        logger.info("Exiting Response: {} {}, response={}", 
                request.getMethod(), request.getRequestURI(), resultJson);
        
        traceApi.trace(resultJson);
	}
	
	/**
	 * Gets the associated HttpRequest
	 * @return httpRequest
	 */
	private HttpServletRequest getRequest() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getRequest();
	}
}
