package com.rafael.hexagonal.architecture.adapters.out;

import org.springframework.stereotype.Component;

import com.rafael.hexagonal.architecture.adapters.out.client.AddressClient;
import com.rafael.hexagonal.architecture.adapters.out.client.mapper.AddressMapper;
import com.rafael.hexagonal.architecture.application.core.domain.Address;
import com.rafael.hexagonal.architecture.application.ports.out.FindAddressByZipCodeOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final AddressClient addressClient;
    private final AddressMapper addressMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = addressClient.findAddressByZipCode(zipCode);
        return addressMapper.toAddress(addressResponse);
    }
    
}
