package com.poc.calculator.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator/")
public class CalculatorController {
	
	@GetMapping("/add")
	public ResponseEntity<BigDecimal> calcular(@RequestParam(value= "operator") String operator, @RequestParam(value= "numbers") BigDecimal... numbers){
		return null;
	}
}
