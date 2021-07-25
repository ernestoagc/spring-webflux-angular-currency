package com.challenge.currency.controller;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.currency.dto.CurrencyDto;
import com.challenge.currency.dto.OperationDto;
import com.challenge.currency.dto.CurrencyExchangeDto;
import com.challenge.currency.dto.CurrencyInputDto;
import com.challenge.currency.service.CurrencyService; 



import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono; 

import org.springframework.http.MediaType;
@RestController
@CrossOrigin(origins="*")
public class CurrencyController {
	
	@Autowired
	CurrencyService currencyService;
	

	Logger logger = LoggerFactory.getLogger(CurrencyController.class);
	
	
	@GetMapping(value="/operations", produces = MediaType.TEXT_EVENT_STREAM_VALUE)	
	@ResponseBody
	public Flux<OperationDto>findStream(@RequestParam Map<String,String> parametros) throws FileNotFoundException  {
		return currencyService.getOperations().delayElements(Duration.ofSeconds(1));
	}
	
	
	@GetMapping(value="/operations2", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)	
	@ResponseBody
	public Flux<OperationDto>findStream2(@RequestParam Map<String,String> parametros) throws FileNotFoundException  {
		return currencyService.getOperations().delayElements(Duration.ofSeconds(1));
	}
	
	
	
	@GetMapping(value="/findall")	
	@ResponseBody
	public Flux<CurrencyDto>findall(@RequestParam Map<String,String> parametros) throws FileNotFoundException  {
		return currencyService.getCurrencies();
	}
	

	@PostMapping("/exchangerate")	
	@ResponseBody
	public Mono<OperationDto>exchangeRate(@RequestBody CurrencyExchangeDto currencyExchangeDto) throws FileNotFoundException  {
		return currencyService.exchangeRate(currencyExchangeDto);
	}

	
	@PostMapping("/currency")	
	@ResponseBody
	public Mono<CurrencyDto>saveCurrency(@RequestBody CurrencyDto currencyDto)  {
		return currencyService.saveCurrency(currencyDto);
	}
	
	
	@PostMapping("/currencies")	
	@ResponseBody
	public Flux<CurrencyDto>saveCurrencies(@RequestBody CurrencyInputDto currencyInputDto)  {
		return currencyService.saveCurrencies(currencyInputDto);
	}

}
