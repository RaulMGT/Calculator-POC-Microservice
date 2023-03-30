package com.poc.calculator.model;

import java.math.BigDecimal;

public class Result {

	private BigDecimal result;

	public Result(BigDecimal result) {
		this.result = result;
	}

	public Result() {
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (result.compareTo(other.result) != 0)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Result [result=" + result + "]";
	}
}
