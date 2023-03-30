package com.poc.calculator.exception;

public class InvalidOperandException extends RuntimeException {

	private static final long serialVersionUID = 5096546749468827350L;

	public InvalidOperandException(String string) {
		super(string);
	}

}
