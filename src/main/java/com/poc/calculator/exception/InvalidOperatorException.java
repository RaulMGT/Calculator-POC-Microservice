package com.poc.calculator.exception;

import java.util.Arrays;

import com.poc.calculator.model.Operator;

public class InvalidOperatorException extends RuntimeException {
	
	private static final long serialVersionUID = 1970619138763105746L;
	private static final String defaultMessage = " Possible values are : " + Arrays.deepToString(Operator.getAllOperators());

	public InvalidOperatorException(String string) {
		super(string + defaultMessage);
	}
}
