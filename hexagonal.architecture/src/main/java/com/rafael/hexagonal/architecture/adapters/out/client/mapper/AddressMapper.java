package com.rafael.hexagonal.architecture.adapters.out.client.mapper;

import org.mapstruct.Mapper;

import com.rafael.hexagonal.architecture.adapters.out.client.response.AddressResponse;
import com.rafael.hexagonal.architecture.application.core.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    
    Address toAddress(AddressResponse src);

}
