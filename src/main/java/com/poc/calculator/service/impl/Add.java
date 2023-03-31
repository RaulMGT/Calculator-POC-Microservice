package com.poc.calculator.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.poc.calculator.model.Operand;
import com.poc.calculator.model.Result;
import com.poc.calculator.service.ArithmeticOperation;

public class Add implements ArithmeticOperation {

	/**
	 * Performs the Add operation to operands
	 * 
	 * @param operands
	 * @return result
	 */
	@Override
	public Result calculate(List<Operand> operands) {
		BigDecimal total = BigDecimal.ZERO;
		for(Operand operand : operands) {
			total = total.add(operand.getValue());
		}
		return new Result(total);
	}
}
