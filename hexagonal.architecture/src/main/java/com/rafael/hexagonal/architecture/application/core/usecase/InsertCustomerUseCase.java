package com.rafael.hexagonal.architecture.application.core.usecase;

import com.rafael.hexagonal.architecture.application.core.domain.Address;
import com.rafael.hexagonal.architecture.application.core.domain.Customer;
import com.rafael.hexagonal.architecture.application.ports.out.FindAddressByZipCodeOutputPort;
import com.rafael.hexagonal.architecture.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutputPort addressPort;
    private final InsertCustomerOutputPort insertPort;
    
    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort addressPort, InsertCustomerOutputPort insertPort) {
        this.addressPort = addressPort;
        this.insertPort = insertPort;
    }

    public void insert(Customer customer, String zipCode) {
        final Address address = addressPort.find(zipCode);

        customer.setAddres(address);

        insertPort.insert(customer);
    }
 
}
