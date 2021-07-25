package com.challenge.currency.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


public class OperationDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String currencyCodeOrigin;
	private String currencyNameOrigin;
	
	private String currencyCodeDestiny;
	private String currencyNameDestiny;
	
	private Double amountExchange;
	
	private Double amount;

	private Double exchangeValue;
	
	
    private LocalDateTime creationDate;
	
	
	
	
	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCurrencyCodeOrigin() {
		return currencyCodeOrigin;
	}

	public void setCurrencyCodeOrigin(String currencyCodeOrigin) {
		this.currencyCodeOrigin = currencyCodeOrigin;
	}
	
	public String getCurrencyNameOrigin() {
		return currencyNameOrigin;
	}

	public void setCurrencyNameOrigin(String currencyNameOrigin) {
		this.currencyNameOrigin = currencyNameOrigin;
	}

	public String getCurrencyCodeDestiny() {
		return currencyCodeDestiny;
	}

	public void setCurrencyCodeDestiny(String currencyCodeDestiny) {
		this.currencyCodeDestiny = currencyCodeDestiny;
	}
	
	public String getCurrencyNameDestiny() {
		return currencyNameDestiny;
	}

	public void setCurrencyNameDestiny(String currencyNameDestiny) {
		this.currencyNameDestiny = currencyNameDestiny;
	}

	public Double getAmountExchange() {
		return amountExchange;
	}

	public void setAmountExchange(Double amountExchange) {
		this.amountExchange = amountExchange;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getExchangeValue() {
		return exchangeValue;
	}

	public void setExchangeValue(Double exchangeValue) {
		this.exchangeValue = exchangeValue;
	}
	
	@Override
	public String toString() {
		return "OperationDto [id=" + id + ", currencyCodeOrigin=" + currencyCodeOrigin + ", currencyNameOrigin="
				+ currencyNameOrigin + ", currencyCodeDestiny=" + currencyCodeDestiny + ", currencyNameDestiny="
				+ currencyNameDestiny + ", amountExchange=" + amountExchange + ", amount=" + amount + ", exchangeValue="
				+ exchangeValue + "]";
	}
	
	

}
