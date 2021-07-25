package com.challenge.currency.service.impl;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.currency.controller.CurrencyController;
import com.challenge.currency.dto.CurrencyDto;
import com.challenge.currency.dto.CurrencyExchangeDto;
import com.challenge.currency.dto.CurrencyInputDto;
import com.challenge.currency.dto.OperationDto;
import com.challenge.currency.model.Currency;
import com.challenge.currency.model.Operation;
import com.challenge.currency.repository.CurrencyRepository;
import com.challenge.currency.repository.OperationRepository;
import com.challenge.currency.service.CurrencyService;
import com.challenge.currency.util.CurrencyUtil;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CurrencyServiceImpl implements CurrencyService {
	
	@Autowired
	CurrencyRepository currencyRepository;
	
	@Autowired
	OperationRepository operationRepository;
	
	LocalDateTime dateCurrent = LocalDateTime.now();
	Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);

	
	public  Mono<OperationDto> exchangeRate(CurrencyExchangeDto currencyExchangeDto) {
		OperationDto operationDto = new OperationDto();
		
		// TODO Auto-generated method stub
		return currencyRepository.findByCurrcencyCode(currencyExchangeDto.getCurrencyCodeOrigin()).
				map(op -> op.getExchangeRates()
						.stream()
						.filter(c-> 
								{
									logger.info("LOGRO");
									return c.getCurrencyCode().equals(currencyExchangeDto.getCurrencyCodeDestiny() );
								}
							 )
						.findFirst()
						.map( ne -> {
							logger.info("====>B");
							operationDto.setCurrencyCodeOrigin(op.getCurrencyCode());							
							operationDto.setCurrencyNameOrigin(op.getCurrencyName());
							operationDto.setCurrencyCodeDestiny(ne.getCurrencyCode());
							operationDto.setCurrencyNameDestiny(ne.getCurrencyName());
							operationDto.setAmount(currencyExchangeDto.getAmount());
							operationDto.setAmountExchange(currencyExchangeDto.getAmount() * ne.getExchangeValue() );
							operationDto.setExchangeValue(ne.getExchangeValue());
							//operationDto.setCreationDate(dateCurrent);
							return operationDto;
						} )
						.orElse(operationDto))
				.flatMap( ope ->  {
					Operation newOperation = CurrencyUtil.objectToObject(Operation.class, operationDto);
					newOperation.setCreationDate(dateCurrent);
					logger.info("====>C");
					logger.info(dateCurrent.toString());
					return operationRepository.save(newOperation); 
				} ).map( newope -> {					
					operationDto.setId(newope.getId());
					operationDto.setCreationDate(newope.getCreationDate());
					return operationDto;
				} )
				.switchIfEmpty(Mono.just(operationDto)); 
				

	}

	@Override
	public Flux<CurrencyDto> getCurrencies() {
		// TODO Auto-generated method stub
		return currencyRepository.findAll()
				.map(obj -> CurrencyUtil.objectToObject(CurrencyDto.class, obj));
	}

	@Override
	public Flux<OperationDto> getOperations() {
		// TODO Auto-generated method stub
		return operationRepository.findAll()
				.map(obj -> CurrencyUtil.objectToObject(OperationDto.class, obj));
	}

	@Override
	public  Mono<CurrencyDto> saveCurrency(CurrencyDto currencyDto) {

		Currency currency = CurrencyUtil.objectToObject(Currency.class, currencyDto);
		
		return currencyRepository.save(currency)
				.map(x-> CurrencyUtil.objectToObject(CurrencyDto.class, x));
		
	}
	
	
	@Override
	public Flux<CurrencyDto> saveCurrencies(CurrencyInputDto currencies) {
		
		return 	Flux.fromIterable(currencies.getCurrencies())
			.flatMap(cu ->  {
				Currency  aux=   CurrencyUtil.objectToObject(Currency.class, cu);	
				
				Mono<Currency> currency =	currencyRepository.findByCurrcencyCode(aux.getCurrencyCode());
				
				
				
				return currencyRepository.save(aux);
			} ).flatMap(ok2 -> {
				CurrencyDto  aux2=   CurrencyUtil.objectToObject(CurrencyDto.class, ok2);
				return Mono.just(aux2);
			});

		
	}
  

}
