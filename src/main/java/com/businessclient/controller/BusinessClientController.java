package com.businessclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.businessclient.model.BusinessClientModel;
import com.businessclient.service.BusinessClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/business-client")
public class BusinessClientController {
	
	@Autowired
	BusinessClientService businessClientService;
	
	@GetMapping("/get/all")
	public Flux<BusinessClientModel> getAll(){
		
		return businessClientService.getAll();
		
	}
	
	@GetMapping("/get/{id}")
	public Mono<BusinessClientModel> getById(@PathVariable String id){
		
		return businessClientService.getById(id);
	}
	
	@PostMapping("/insert")
	public Mono<BusinessClientModel> insertBusinessClient (@RequestBody BusinessClientModel businessClientModel) {
		
		return businessClientService.insertBusinessClient(businessClientModel);
		
	}
	
	@PutMapping("/delete/{id}")
	public Mono<BusinessClientModel> deleteBusinessClient(@RequestBody BusinessClientModel businessClientModel, @PathVariable String id){
		
		return businessClientService.deleteBusinessClient(businessClientModel, id);
	}
	
	@PutMapping("/update/{id}")
	public Mono<BusinessClientModel> updateBusinessClient(@RequestBody BusinessClientModel businessClientModel, @PathVariable String id){
		
		return businessClientService.updateBusinessClient(businessClientModel, id);
	}

}
