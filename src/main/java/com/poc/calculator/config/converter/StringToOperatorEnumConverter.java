package com.poc.calculator.config.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.poc.calculator.exception.InvalidOperatorException;
import  com.poc.calculator.model.Operator;

@Component
public class StringToOperatorEnumConverter implements Converter<String, Operator>{

	/**
	 * Transform from String to {@link Operator}
	 * 
	 * @param source input path variable
	 * @return valid operator
	 * @throws InvalidOperatorException if source is not a valid operator
	 */
	@Override
	public Operator convert(String source){
		try {
			return Operator.valueOf(source.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new InvalidOperatorException("Invalid operator: \"" + source + "\".");
		}
	}

}
