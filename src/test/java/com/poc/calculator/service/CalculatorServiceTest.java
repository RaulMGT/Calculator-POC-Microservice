package com.poc.calculator.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {
	
	@Spy
	private CalculatorService calculatorService;
	
	@Test
	public void testAdd() {
		BigDecimal number1 = new BigDecimal("0.3");
		BigDecimal number2 = new BigDecimal("0.4");
		
		BigDecimal result = calculatorService.add(number1, number2);
		
		Assertions.assertEquals(new BigDecimal("0.7"), result);
	}
	
	@Test
	public void testSubtract() {
		BigDecimal number1 = new BigDecimal("0.3");
		BigDecimal number2 = new BigDecimal("0.4");
		
		BigDecimal result = calculatorService.subtract(number1, number2);
		
		Assertions.assertEquals(new BigDecimal("-0.1"), result);
	}
}
