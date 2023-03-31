package com.poc.calculator.exception;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.poc.calculator.config.converter.StringToOperandListConverter;
import com.poc.calculator.util.Utils;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<String> handleInvalidOperatorException(MethodArgumentTypeMismatchException ex) {
		Throwable throwable = ex;
		ResponseEntity<String> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(throwable.getMessage());
		if(ex != null && ex.getCause() != null && ex.getCause().getCause() != null) {
						
			throwable = ex.getCause() //ConversionFailedException
					.getCause(); 	  //InvalidOperatorException
			
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(throwable.getMessage());
			logException(response, throwable);
		}
        return response;
    }
	
	
	@ExceptionHandler(MethodArgumentConversionNotSupportedException.class)
	protected ResponseEntity<String> handleInvalidOperandException(MethodArgumentConversionNotSupportedException ex) {
		Throwable throwable = ex;
		ResponseEntity<String> response = null;
		try {
			StringToOperandListConverter converter = new StringToOperandListConverter();
			converter.convert((String) ex.getValue());
		} catch (InvalidOperandException customException){
			throwable = customException;
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customException.getMessage());
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
		logException(response, throwable);

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