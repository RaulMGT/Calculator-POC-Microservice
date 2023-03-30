package com.poc.calculator.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.poc.calculator.model.Operand;
import com.poc.calculator.model.Operator;
import com.poc.calculator.model.Result;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {
	
	@Spy
	private CalculatorService calculatorService;
	
	@Test
	public void testAdd() {
		BigDecimal operand1 = new BigDecimal("0.3");
		BigDecimal operand2 = new BigDecimal("0.4");
		List<Operand> operands = new ArrayList<>();
		operands.add(new Operand(operand1));
		operands.add(new Operand(operand2));
		
		Result result = calculatorService.calculate(Operator.ADD, operands);
		
		Assertions.assertEquals(new Result(new BigDecimal("0.7")), result);
	}
	
	@Test
	public void testSubtract() {
		BigDecimal operand1 = new BigDecimal("0.3");
		BigDecimal operand2 = new BigDecimal("0.4");
		List<Operand> operands = new ArrayList<>();
		operands.add(new Operand(operand1));
		operands.add(new Operand(operand2));
		
		Result result = calculatorService.calculate(Operator.SUBTRACT, operands);
		
		Assertions.assertEquals(new Result(new BigDecimal("-0.1")), result);
	}
}
