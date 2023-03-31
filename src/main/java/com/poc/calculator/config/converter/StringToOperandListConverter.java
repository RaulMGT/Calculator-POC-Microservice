package com.poc.calculator.config.converter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.poc.calculator.exception.InvalidOperandException;
import com.poc.calculator.model.Operand;

@Component
public class StringToOperandListConverter implements Converter<String, List<Operand>> {

	@Override
	public List<Operand> convert(String source) {
		
		AtomicInteger i = new AtomicInteger(0);
		String[] operandsArray = source.split(",");
		
		try {
			return Arrays.stream(operandsArray)
					.map(operand -> new Operand(new BigDecimal(operand)))
					.peek(o -> i.incrementAndGet())
					.collect(Collectors.toList());
		} catch (NumberFormatException ex) {
			throw new InvalidOperandException("Invalid operand: \"" + operandsArray[i.get()] + "\" is not a number.");
		}
	}
}
