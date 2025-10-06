package com.rafael.hexagonal.architecture.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rafael.hexagonal.architecture.adapters.in.controller.request.CustomerRequest;
import com.rafael.hexagonal.architecture.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest src);

}
