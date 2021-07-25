package com.challenge.currency.dto;

import java.io.Serializable;

public class ExchangeRateDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String currencyCode;
	private String currencyName; 
	private Double exchangeValue;
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	@Override
	public String toString() {
		return "ExchangeRateDto [currencyCode=" + currencyCode + ", currencyName=" + currencyName + ", exchangeValue="
				+ exchangeValue + "]";
	}

	
	
	

}
