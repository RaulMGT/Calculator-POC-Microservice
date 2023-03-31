package com.poc.calculator.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.poc.calculator.model.Operand;
import com.poc.calculator.model.Result;
import com.poc.calculator.service.ArithmeticOperation;

public class Subtract implements ArithmeticOperation {

	/**
	 * Performs the Subtract operation to operands
	 * 
	 * @param operands
	 * @return result
	 */
	@Override
	public Result calculate(List<Operand> operands) {
		BigDecimal total = operands.get(0).getValue();
		for(int i = 1; i < operands.size(); i++) {
			total = total.subtract(operands.get(i).getValue());
		}
		return new Result(total);
	}

}
