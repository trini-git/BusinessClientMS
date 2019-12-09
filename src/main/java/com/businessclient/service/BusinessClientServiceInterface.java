package com.businessclient.service;

import com.businessclient.model.BusinessClientModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BusinessClientServiceInterface {

	//we need to create our own methods
	
	Flux<BusinessClientModel> getAll();
	Mono<BusinessClientModel> getById(String id);
	Mono<BusinessClientModel> insertBusinessClient(BusinessClientModel businessClientModel);
	Mono<BusinessClientModel> deleteBusinessClient(BusinessClientModel businessClientModel, String id);
	Mono<BusinessClientModel> updateBusinessClient(BusinessClientModel businessClientModel, String id);
}
