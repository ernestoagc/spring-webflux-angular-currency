package com.challenge.currency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.challenge.currency.controller.CurrencyHandler;
 
@Configuration
public class RouterFunctionConfig {
	
	@Bean
	public RouterFunction<ServerResponse> routeCurrency(CurrencyHandler handler){		
		return RouterFunctions.route(RequestPredicates.GET("/stream/operations"),
				request -> handler.allOperations(request)).
				andRoute(RequestPredicates.POST("/stream/exchangerate"), handler::exchangeCurrency);
		
	}

}
