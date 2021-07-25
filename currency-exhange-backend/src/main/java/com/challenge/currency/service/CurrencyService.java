package com.challenge.currency.service;
import com.challenge.currency.dto.CurrencyDto;
import com.challenge.currency.dto.CurrencyExchangeDto;
import com.challenge.currency.dto.CurrencyInputDto;
import com.challenge.currency.dto.OperationDto;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface CurrencyService {
	
	 Mono<OperationDto> exchangeRate(CurrencyExchangeDto currencyExchangeDto) ;
	 Mono<CurrencyDto> saveCurrency(CurrencyDto currencyDto);
	 Flux<CurrencyDto> saveCurrencies(CurrencyInputDto currencies);
     Flux<CurrencyDto> getCurrencies();     
     Flux<OperationDto> getOperations();
}
