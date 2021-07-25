package com.challenge.currency.dto;

public class CurrencyExchangeDto {

	private String  currencyCodeOrigin;
	private String  currencyCodeDestiny;
	private Double amount;
	public String getCurrencyCodeOrigin() {
		return currencyCodeOrigin;
	}
	public void setCurrencyCodeOrigin(String currencyCodeOrigin) {
		this.currencyCodeOrigin = currencyCodeOrigin;
	}
	public String getCurrencyCodeDestiny() {
		return currencyCodeDestiny;
	}
	public void setCurrencyCodeDestiny(String currencyCodeDestiny) {
		this.currencyCodeDestiny = currencyCodeDestiny;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "CurrencyExchangeDto [currencyCodeOrigin=" + currencyCodeOrigin + ", currencyCodeDestiny="
				+ currencyCodeDestiny + ", amount=" + amount + "]";
	}

	
	
	
	
}
