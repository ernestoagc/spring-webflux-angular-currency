package com.challenge.currency.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.challenge.currency.model.Operation;

public interface OperationRepository  extends ReactiveMongoRepository<Operation, String> {

}
