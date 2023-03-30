package com.poc.calculator.model.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.poc.calculator.model.Calculator;

public class CalculatorValidator {
	
	public static boolean validate(Calculator calculator) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Calculator>> violations = validator.validate(calculator);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        return true;
    }	
}
