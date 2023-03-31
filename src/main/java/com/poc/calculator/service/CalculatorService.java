package com.poc.calculator.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;

import com.poc.calculator.factory.CalculatorFactory;
import com.poc.calculator.model.Calculator;
import com.poc.calculator.model.Operand;
import com.poc.calculator.model.Operator;
import com.poc.calculator.model.Result;
import com.poc.calculator.model.validator.CalculatorValidator;

@Service
public class CalculatorService {

	/**
	 * Calculates operation using operator and operands
	 * 
	 * @param operator 
	 * @param operands
	 * @return operation result
	 */
	public Result calculate(Operator operator, List<Operand> operands) {
		ArithmeticOperation operation = createValidArithmeticOperation(operator, operands);
		return operation.calculate(operands);
	}

	/**
	 * Creates a valid calculator or arises any problems found
	 * @param operator
	 * @param operands
	 * @return operation to perform
	 * @throws ConstraintViolationException if calculator is not valid
	 */
	private ArithmeticOperation createValidArithmeticOperation(Operator operator, List<Operand> operands) {
		Calculator calculator = new Calculator.Builder()
				.withOperator(operator)
				.withOperands(operands)
				.build();
		CalculatorValidator.validate(calculator);
		return CalculatorFactory.getInstance(operator);
	}
}
