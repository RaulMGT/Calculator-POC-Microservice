package com.poc.calculator.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.poc.calculator.model.Result;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorIntegrationTest {
	
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void testAdd() {
        String url = "http://localhost:" + port + "/api/v1/calculator/add?operands=2,3";
        ResponseEntity<Result> response = restTemplate.getForEntity(url, Result.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new Result(new BigDecimal("5")), response.getBody());
    }

    @Test
    public void testSubtract() {
    	String url = "http://localhost:" + port + "/api/v1/calculator/subtract?operands=0.2,0.3";
        ResponseEntity<Result> response = restTemplate.getForEntity(url, Result.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new Result(new BigDecimal("-0.1")), response.getBody());
    }
}
