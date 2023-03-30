package com.poc.calculator.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.calculator.service.CalculatorService;

@RestController
@RequestMapping("/api/v1/calculator/")
public class CalculatorController {
	
	@Autowired
	private CalculatorService calculatorService;
	
	@GetMapping("/{operator}")
	public ResponseEntity<BigDecimal> calculate(@PathVariable(value= "operator") String operator, @RequestParam(value= "numbers") BigDecimal... numbers){
		return ResponseEntity.ok(calculatorService.calculate(operator, numbers));
	}
}
