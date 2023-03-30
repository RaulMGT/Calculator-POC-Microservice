package com.poc.calculator.service;

import java.math.BigDecimal;

@FunctionalInterface
public interface ArithmeticOperation {
	BigDecimal calculate(BigDecimal... numbers);
}
