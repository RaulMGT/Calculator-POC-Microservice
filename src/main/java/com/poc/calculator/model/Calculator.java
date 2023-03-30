package com.poc.calculator.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Calculator {

	@NotNull
	@Valid
	private Operator operator;
	
	@NotNull
	@Valid
	@Size(min = 2)
	private List<Operand> operands;
	
	public Calculator() {}
	
	public Calculator(Operator operator, List<Operand> operand) {
		this.operator = operator;
		this.operands = operand;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public List<Operand> getOperands() {
		return operands;
	}

	public void setOperands(List<Operand> operands) {
		this.operands = operands;
	}
	
	public void addOperand(Operand operand) {
		if (operands == null) {
			operands = new ArrayList<>();
		} 
		operands.add(operand);
	}
	
	public static class Builder {
		
		private Calculator calculator;
		
		public Builder() {
			calculator = new Calculator();
		}
		
		public Builder withOperator(Operator operator) {
			calculator.operator = operator;
			return this;
		}
		
		public Builder withOperands(List<Operand> operands) {
			calculator.operands = operands;
			return this;
		}
		
		public Calculator build() {
			return calculator;
		}
	}
}
