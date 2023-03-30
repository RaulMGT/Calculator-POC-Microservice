package com.poc.calculator.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.poc.calculator.factory.CalculatorFactory;
import com.poc.calculator.model.Operator;

@Service
public class CalculatorService {
	
	public BigDecimal calculate(String operator, BigDecimal... numbers) {
		try {
			ArithmeticOperation operation = CalculatorFactory.getInstance(Operator.valueOf(operator.toUpperCase()));
			return operation.calculate(numbers);
		} catch (IllegalArgumentException e) {
			
		} catch (Exception e) {
		}
		return null;
	}
}
