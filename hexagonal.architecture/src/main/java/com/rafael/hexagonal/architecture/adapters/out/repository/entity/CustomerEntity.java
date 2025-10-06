package com.rafael.hexagonal.architecture.adapters.out.repository.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document(collection = "customers")
public class CustomerEntity {
    
    @MongoId
    private String id;
    private String name;
    private AddressEntity address;
    private String cpf;
    private Boolean isValidCpf;

}
