package com.challenge.currency.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="currencies")
public class Currency  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
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
	
	public ExchangeRate getExchangeCurrency(String currencyCode) {
		return this.exchangeRates.stream().filter(uni -> uni.equals(currencyCode)).findAny().get();	
	} 

	@Override
	public String toString() {
		return "Currency [id=" + id + ", currencyCode=" + currencyCode + ", currencyName=" + currencyName
				+ ", exchangeRates=" + exchangeRates + "]";
	}
	
	
	
	
	
	public Currency() {}
	
	
	
	
}
