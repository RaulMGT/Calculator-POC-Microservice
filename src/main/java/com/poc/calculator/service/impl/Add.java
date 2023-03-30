package com.poc.calculator.service.impl;

import java.math.BigDecimal;

import com.poc.calculator.service.ArithmeticOperation;

public class Add implements ArithmeticOperation {

	@Override
	public BigDecimal calculate(BigDecimal... numbers) {
		BigDecimal total = BigDecimal.ZERO;
		for(BigDecimal number : numbers) {
			total = total.add(number);
		}
		return total;
	}

}
