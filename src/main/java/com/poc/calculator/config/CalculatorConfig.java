package com.poc.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poc.calculator.trace.TracerImplAdapter;

import io.corp.calculator.TracerAPI;

@Configuration
public class CalculatorConfig {
	
	/**
	 * Configures TracerAPI object
	 * @return TracerAPI
	 */
	@Bean
	public TracerAPI tracerAPI() {
		return new TracerImplAdapter();
	}
}
