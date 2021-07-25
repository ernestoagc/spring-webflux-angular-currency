package com.challenge.currency.dto;

import java.io.Serializable;
import java.util.List;

import com.challenge.currency.model.ExchangeRate;

public class CurrencyDto implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String currencyCode;
	private String currencyName;
	private List<ExchangeRate> exchangeRates;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public List<ExchangeRate> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(List<ExchangeRate> exchangeRates) {
		this.exchangeRates = exchangeRates;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", currencyCode=" + currencyCode + ", currencyName=" + currencyName
				+ ", exchangeRates=" + exchangeRates + "]";
	}
}
