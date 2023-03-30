package com.poc.calculator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.calculator.factory.CalculatorFactory;
import com.poc.calculator.model.Calculator;
import com.poc.calculator.model.Operand;
import com.poc.calculator.model.Operator;
import com.poc.calculator.model.Result;
import com.poc.calculator.model.validator.CalculatorValidator;

@Service
public class CalculatorService {

	public Result calculate(Operator operator, List<Operand> operands) {
		ArithmeticOperation operation = createValidArithmeticOperation(operator, operands);
		return operation.calculate(operands);
	}

	private ArithmeticOperation createValidArithmeticOperation(Operator operator, List<Operand> operands) {
		Calculator calculator = new Calculator.Builder()
				.withOperator(operator)
				.withOperands(operands)
				.build();
		CalculatorValidator.validate(calculator);
		return CalculatorFactory.getInstance(operator);
	}
}
