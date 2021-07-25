package com.challenge.currency.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.challenge.currency.model.Currency;

import reactor.core.publisher.Mono;

@Repository
public interface CurrencyRepository extends ReactiveMongoRepository<Currency, String>  {
	
	@Query("{ 'currencyCode': ?0 }")
    Mono<Currency> findByCurrcencyCode(String currencyCode);
}
