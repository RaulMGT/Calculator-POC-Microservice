package com.poc.calculator.config;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.poc.calculator.config.converter.StringToOperandListConverter;
import com.poc.calculator.config.converter.StringToOperatorEnumConverter;

public class WebConfig implements WebMvcConfigurer {
	
	@Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToOperatorEnumConverter());
        registry.addConverter(new StringToOperandListConverter());
    }
}
