package com.poc.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.poc.calculator.model.Operand;
import com.poc.calculator.model.Operator;
import com.poc.calculator.model.Result;
import com.poc.calculator.service.CalculatorService;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
	
	@Mock
	private CalculatorService calculatorService;
	
	@InjectMocks
	private CalculatorController calculatorController;
	
	@Test
	public void testAdd() {
		BigDecimal operand1 = new BigDecimal("1");
		BigDecimal operand2 = new BigDecimal("2");
		List<Operand> operands = new ArrayList<>();
		operands.add(new Operand(operand1));
		operands.add(new Operand(operand2));
		
		Result result = new Result(new BigDecimal("3"));
		Mockito.when(calculatorService.calculate(Operator.ADD, operands)).thenReturn(result);
		
		ResponseEntity<Result> response = calculatorController.calculate(Operator.ADD, operands);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(result, response.getBody());	
	}
	
	@Test
	public void testSubtract() {
		BigDecimal operand1 = new BigDecimal("1");
		BigDecimal operand2 = new BigDecimal("2");
		List<Operand> operands = new ArrayList<>();
		operands.add(new Operand(operand1));
		operands.add(new Operand(operand2));
		
		Result result = new Result(new BigDecimal("-1"));
		Mockito.when(calculatorService.calculate(Operator.SUBTRACT, operands)).thenReturn(result);
		
		ResponseEntity<Result> response = calculatorController.calculate(Operator.SUBTRACT, operands);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(result, response.getBody());	
	}
}
