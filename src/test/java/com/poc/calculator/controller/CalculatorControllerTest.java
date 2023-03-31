package com.poc.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.poc.calculator.model.Operand;
import com.poc.calculator.model.Result;
import com.poc.calculator.service.CalculatorService;
import com.poc.calculator.util.Utils;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;
	
	@Test
	public void testAdd() throws Exception {
		BigDecimal operand1 = new BigDecimal("1");
		BigDecimal operand2 = new BigDecimal("2");
		List<Operand> operands = new ArrayList<>();
		operands.add(new Operand(operand1));
		operands.add(new Operand(operand2));
		
		Result result = new Result(new BigDecimal("3"));
		String resultJson = Utils.convertToJson(result);
		
		Mockito.when(calculatorService.calculate(any(), any())).thenReturn(result);
		
		MvcResult httpResult = mockMvc.perform(get("/api/v1/calculator/add")
                .param("operands", "1,2"))
                .andExpect(status().isOk())
                .andReturn();
		
		String content = httpResult.getResponse().getContentAsString();
		assertEquals(resultJson, content);
	}
	
	@Test
	public void testSubtract() throws Exception {
		Result result = new Result(new BigDecimal("-1"));
		String resultJson = Utils.convertToJson(result);
		
		Mockito.when(calculatorService.calculate(any(), any())).thenReturn(result);
		
		MvcResult httpResult = mockMvc.perform(get("/api/v1/calculator/subtract")
                .param("operands", "1,2"))
                .andExpect(status().isOk())
                .andReturn();
		
		String content = httpResult.getResponse().getContentAsString();
		assertEquals(resultJson, content);
	}
	
	@Test
	public void testInvalidOperator() throws Exception {
		Mockito.when(calculatorService.calculate(any(), any())).thenCallRealMethod();
		
		mockMvc.perform(get("/api/v1/calculator/division")
                .param("operands", "1,2"))
                .andExpect(status().isBadRequest())
                .andReturn();
	}
	
	@Test
	public void testInvalidOperandsSize() throws Exception {
		Mockito.when(calculatorService.calculate(any(), any())).thenCallRealMethod();
		
		mockMvc.perform(get("/api/v1/calculator/add")
                .param("operands", "1"))
                .andExpect(status().isBadRequest())
                .andReturn();
	}
	
	@Test
	public void testInvalidOperandsNotANumber() throws Exception {
		Mockito.when(calculatorService.calculate(any(), any())).thenCallRealMethod();
		
		mockMvc.perform(get("/api/v1/calculator/add")
                .param("operands", "1,a"))
                .andExpect(status().isBadRequest())
                .andReturn();
	}
}
