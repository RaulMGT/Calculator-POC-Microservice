package com.poc.calculator.model;

import java.util.Arrays;

public enum Operator {
	ADD,
	SUBTRACT;

	/**
	 * 
	 * @return all possible operators
	 */
	public static String[] getAllOperators() {
		return Arrays.stream(Operator.values())
				.map(operator -> operator.toString().toLowerCase())
				.toArray(String[]::new);
	}
}
