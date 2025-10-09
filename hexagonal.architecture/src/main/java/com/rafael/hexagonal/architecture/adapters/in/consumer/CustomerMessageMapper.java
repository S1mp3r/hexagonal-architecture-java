package com.rafael.hexagonal.architecture.adapters.in.consumer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rafael.hexagonal.architecture.adapters.in.consumer.message.CustomerMessage;
import com.rafael.hexagonal.architecture.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {
    
    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage src);

}
