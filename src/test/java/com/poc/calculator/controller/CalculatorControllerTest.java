package com.poc.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.poc.calculator.service.CalculatorService;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
	
	@Mock
	private CalculatorService calculatorService;
	
	@InjectMocks
	private CalculatorController calculatorController;
	
	@Test
	public void testAdd() {
		BigDecimal number1 = new BigDecimal("1");
		BigDecimal number2 = new BigDecimal("2");
		BigDecimal result = new BigDecimal("3");
		Mockito.when(calculatorService.calculate("add", number1, number2)).thenReturn(result);
		
		ResponseEntity<BigDecimal> response = calculatorController.calculate("add", number1, number2);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(result, response.getBody());	
	}
	
	@Test
	public void testSubtract() {
		BigDecimal number1 = new BigDecimal("1");
		BigDecimal number2 = new BigDecimal("2");
		BigDecimal result = new BigDecimal("-1");
		Mockito.when(calculatorService.calculate("subtract", number1, number2)).thenReturn(result);
		
		ResponseEntity<BigDecimal> response = calculatorController.calculate("subtract", number1, number2);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(result, response.getBody());	
	}
}
