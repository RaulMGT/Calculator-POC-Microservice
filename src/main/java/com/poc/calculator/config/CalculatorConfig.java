package com.poc.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poc.calculator.trace.TracerAPIAdapter;
import com.poc.calculator.trace.TracerImplAdapter;

@Configuration
public class CalculatorConfig {
	
	@Bean
	public TracerAPIAdapter tracerAPI() {
		return new TracerImplAdapter();
	}
}
