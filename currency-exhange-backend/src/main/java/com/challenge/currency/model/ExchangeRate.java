package com.challenge.currency.model;

import java.io.Serializable;

public class ExchangeRate  implements Serializable{
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
	public Double getExchangeValue() {
		return exchangeValue;
	}
	public void setExchangeValue(Double exchangeValue) {
		this.exchangeValue = exchangeValue;
	}
	@Override
	public String toString() {
		return "ExchangeRate [currencyCode=" + currencyCode + ", currencyName=" + currencyName + ", exchangeValue="
				+ exchangeValue + "]";
	}

	
	
	public ExchangeRate() {
		
	}
	
	
	
}
