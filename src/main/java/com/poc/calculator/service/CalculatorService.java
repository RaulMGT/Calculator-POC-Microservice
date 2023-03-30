package com.poc.calculator.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.poc.calculator.service.impl.Add;
import com.poc.calculator.service.impl.Subtract;

@Service
public class CalculatorService {

	public BigDecimal add(BigDecimal... numbers) {
		Add add = new Add();
		return add.calculate(numbers);
	}

	public BigDecimal subtract(BigDecimal... numbers) {
		Subtract sub = new Subtract();
		return sub.calculate(numbers);
	}

}
