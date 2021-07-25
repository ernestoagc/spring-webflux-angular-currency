package com.challenge.currency.dto;

import java.io.Serializable;
import java.util.List;


public class CurrencyInputDto implements Serializable{
	
	
	private List<CurrencyDto> currencies;

	public List<CurrencyDto> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<CurrencyDto> currencies) {
		this.currencies = currencies;
	}

	@Override
	public String toString() {
		return "CurrencyInputDto [currencies=" + currencies + "]";
	}
	
	
	

}
