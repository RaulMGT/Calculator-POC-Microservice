package com.poc.calculator.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
	
	private final static Logger logger = LoggerFactory.getLogger(Utils.class);
	
	/**
	 * 
	 * @param object
	 * @return string value in Json format
	 */
	public static String convertToJson(Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
	    String objectJson = "";
	    try {
	    	objectJson = objectMapper.writeValueAsString(object);
	    } catch (JsonProcessingException e) {
	        logger.error("Error serializing request parameters to JSON: ", e);
	    }
	    return objectJson;
	}
}
