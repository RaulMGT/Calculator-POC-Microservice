package com.poc.calculator.service.impl;

import java.math.BigDecimal;

import com.poc.calculator.service.ArithmeticOperation;

public class Subtract implements ArithmeticOperation {

	@Override
	public BigDecimal calculate(BigDecimal... numbers) {
		BigDecimal total = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			total = total.subtract(numbers[i]);
		}
		return total;
	}

}
