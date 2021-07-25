package com.challenge.currency.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer; 

@Document(collection="operations")
public class Operation implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	
	private String currencyCodeOrigin;
	private String currencyNameOrigin;
	
	private String currencyCodeDestiny;
	private String currencyNameDestiny;
	
	private Double amountExchange;
	
	private Double amount;

	private Double exchangeValue;
	

    @JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
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
		return "Operation [currencyCodeOrigin=" + currencyCodeOrigin + ", currencyNameOrigin=" + currencyNameOrigin
				+ ", currencyCodeDestiny=" + currencyCodeDestiny + ", currencyNameDestiny=" + currencyNameDestiny
				+ ", amountExchange=" + amountExchange + ", amount=" + amount + ", exchangeValue=" + exchangeValue
				+ "]";
	}
	
	

}
