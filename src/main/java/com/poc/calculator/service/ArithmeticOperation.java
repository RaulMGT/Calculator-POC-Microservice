package com.poc.calculator.service;

import java.util.List;

import com.poc.calculator.model.Operand;
import com.poc.calculator.model.Result;

@FunctionalInterface
public interface ArithmeticOperation {
	Result calculate(List<Operand> operands);
}
