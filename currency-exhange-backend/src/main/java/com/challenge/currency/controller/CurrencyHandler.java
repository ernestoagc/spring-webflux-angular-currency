package com.challenge.currency.controller;

import java.net.URI;
import java.time.Duration;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.challenge.currency.dto.CurrencyDto;
import com.challenge.currency.dto.CurrencyExchangeDto;
import com.challenge.currency.dto.OperationDto;
import com.challenge.currency.service.CurrencyService;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CurrencyHandler {
	
	@Autowired
	CurrencyService currencyService;
	
	public Mono<ServerResponse> allOperations(ServerRequest request){
		 
		return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON)
				.body(currencyService.getOperations().delayElements(Duration.ofSeconds(1)).log(),OperationDto.class);
	}
	
	
	public Mono<ServerResponse> exchangeCurrency(ServerRequest request){
		
		Mono<CurrencyExchangeDto> requestObject = request.bodyToMono(CurrencyExchangeDto.class);
		
		return requestObject.flatMap(obj-> {			
			return currencyService.exchangeRate(obj);
		} ).flatMap(p -> ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8).body(BodyInserters.fromObject(p)));
		 
		
		//return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(productoDao.findAll(),Producto.class);
	}
	
	
}
