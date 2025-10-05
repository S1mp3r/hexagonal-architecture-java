package com.rafael.hexagonal.architecture.application.ports.out;

import com.rafael.hexagonal.architecture.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    public Address find(String zipCode);
    
}