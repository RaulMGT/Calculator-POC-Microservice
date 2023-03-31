package com.poc.calculator.factory;

import com.poc.calculator.exception.InvalidOperatorException;
import com.poc.calculator.model.Operator;
import com.poc.calculator.service.ArithmeticOperation;
import com.poc.calculator.service.impl.Add;
import com.poc.calculator.service.impl.Subtract;

public class CalculatorFactory {

	/**
	 * Associates an operator with the ArithmeticOperation to execute
	 * 
	 * @param operator
	 * @return ArithmeticOperation to perform
	 */
	public static ArithmeticOperation getInstance(Operator operator) {
		switch(operator) {
			case ADD:
				return new Add();
			case SUBTRACT:
				return new Subtract();
			default:
				throw new InvalidOperatorException("Invalid operator: \"" + operator + "\".");
		}
	}
}
