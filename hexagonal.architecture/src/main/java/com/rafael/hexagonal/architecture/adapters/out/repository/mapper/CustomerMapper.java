package com.rafael.hexagonal.architecture.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import com.rafael.hexagonal.architecture.adapters.out.repository.entity.CustomerEntity;
import com.rafael.hexagonal.architecture.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    
    public CustomerEntity toCustomerEntity(Customer src);
    public Customer toCustomer(CustomerEntity src);

}
