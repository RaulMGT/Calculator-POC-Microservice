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

import com.poc.calculator.trace.TracerAPIAdapter;
import com.poc.calculator.util.Utils;

@Aspect
@Component
public class LoggingAspect {
	
	@Autowired
	private TracerAPIAdapter traceApi;
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(* com.poc.calculator.controller.CalculatorController.*(..))")
    public void controllerMethods() {}
	
	@Before("controllerMethods()")
    public void logMethodEntry(JoinPoint joinPoint) {
		HttpServletRequest request = getRequest();
		
		String paramsJson = Utils.convertToJson(request.getParameterMap());
	   
        logger.info("Incoming Request: {} {}, params={}", 
                request.getMethod(), request.getRequestURI(), paramsJson);
    }
	
	@AfterReturning(pointcut= "controllerMethods()", returning="result")
	public void logMethodExitAndTraceResult(JoinPoint joinPoint, Object result) {
		HttpServletRequest request = getRequest();
		
		String resultJson = Utils.convertToJson(result);
	    
        logger.info("Exiting Response: {} {}, response={}", 
                request.getMethod(), request.getRequestURI(), resultJson);
        
        traceApi.trace(resultJson);
	}
	
	private HttpServletRequest getRequest() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes.getRequest();
	}
}
