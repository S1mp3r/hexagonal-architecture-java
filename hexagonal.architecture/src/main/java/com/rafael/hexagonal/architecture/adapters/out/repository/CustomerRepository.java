package com.rafael.hexagonal.architecture.adapters.out.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafael.hexagonal.architecture.adapters.out.repository.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
    
}