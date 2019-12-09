package com.businessclient.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.businessclient.model.BusinessClientModel;

@Repository
public interface BusinessClientRepositoryInterface extends ReactiveMongoRepository<BusinessClientModel, String>{

}
