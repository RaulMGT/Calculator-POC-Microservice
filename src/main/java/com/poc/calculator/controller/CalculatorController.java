package com.poc.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.calculator.model.Operand;
import com.poc.calculator.model.Operator;
import com.poc.calculator.model.Result;
import com.poc.calculator.service.CalculatorService;

/**
 * Manages requests with path /api/v1/calculator/
 */
@RestController
@RequestMapping("/api/v1/calculator/")
public class CalculatorController {
	
	@Autowired
	private CalculatorService calculatorService;
	
	/**
	 * Processes the incoming request performing an arithmetic operation using
	 * operands and the operator to apply
	 * 
	 * @param operator
	 * @param operands 
	 * @return response entity containing http status and result value
	 */
	@GetMapping("/{operator}")
	public ResponseEntity<Result> calculate(@PathVariable(value= "operator") Operator operator, @RequestParam(value= "operands") List<Operand> operands){
		return ResponseEntity.ok(calculatorService.calculate(operator, operands));
	}
}
