package com.poc.calculator.exception;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.poc.calculator.util.Utils;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);
	
	@ExceptionHandler(InvalidOperatorException.class)
    protected ResponseEntity<String> handleInvalidOperatorException(InvalidOperatorException ex) {
		ResponseEntity<String> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		logException(response, ex);
        return response;
    }
	
	@ExceptionHandler(NumberFormatException.class)
    protected ResponseEntity<String> handleNumberFormatException(NumberFormatException ex) {
		ResponseEntity<String> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		logException(response, ex);
        return response;
    }
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		Throwable throwable = ex;
		ResponseEntity<String> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(throwable.getMessage());
		if(ex != null && ex.getCause() != null && ex.getCause().getCause() != null) {
						
			throwable = ex.getCause() //ConversionFailedException
					.getCause(); 	  //Custom converter exception
			logException(response, throwable);
		}
        return response;
    }
	
	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
		ResponseEntity<String> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		logException(response, ex);
        return response;
    }
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<String> handleGenericException(Exception ex) {
		ResponseEntity<String> response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		logException(response, ex);
        return response;
    }
	
	private void logException(ResponseEntity<String> response, Throwable throwable) {
		if(response != null && throwable != null) {
			logger.error(Utils.convertToJson(response), throwable);
		}
	}
}