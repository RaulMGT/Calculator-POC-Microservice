package com.poc.calculator.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

/**
 * Represents an Operand
 */
public class Operand {

	@NotNull
	private BigDecimal value;
	
	public Operand(BigDecimal value) {
		this.value = value;
	}
	
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Operand [value=" + value + "]";
	}
}
