package com.businessclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businessclient.model.BusinessClientModel;
import com.businessclient.repository.BusinessClientRepositoryInterface;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BusinessClientService implements BusinessClientServiceInterface{
	
	@Autowired
	BusinessClientRepositoryInterface businessClientRepository;
	 
	@Override
	public Flux<BusinessClientModel> getAll() {
		
		return businessClientRepository.findAll();
	}

	@Override
	public Mono<BusinessClientModel> getById(String id) {
		
		return businessClientRepository.findById(id);
	}

	@Override
	public Mono<BusinessClientModel> insertBusinessClient(BusinessClientModel businessClientModel) {
		
		return businessClientRepository.save(businessClientModel);
	}

	@Override
	public Mono<BusinessClientModel> deleteBusinessClient(BusinessClientModel businessClientModel, String id) {
		
		return businessClientRepository.findById(id)
			.flatMap(businessClient -> {
				businessClient.setStatus("I");
				return businessClientRepository.save(businessClient);
			});
	}

	@Override
	public Mono<BusinessClientModel> updateBusinessClient(BusinessClientModel businessClientModel, String id) {
		
		return businessClientRepository.findById(id).
			flatMap(businessClient -> {
				businessClient.setDocument(businessClientModel.getDocument());
				businessClient.setName(businessClientModel.getName());
				businessClient.setLastName(businessClientModel.getLastName());
				return businessClientRepository.save(businessClient);
			});
		}
	}

