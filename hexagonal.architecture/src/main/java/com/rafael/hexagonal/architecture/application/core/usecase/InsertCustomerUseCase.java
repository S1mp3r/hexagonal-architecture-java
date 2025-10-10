package com.rafael.hexagonal.architecture.application.core.usecase;

import com.rafael.hexagonal.architecture.application.core.domain.Address;
import com.rafael.hexagonal.architecture.application.core.domain.Customer;
import com.rafael.hexagonal.architecture.application.ports.in.InsertCustomerInputPort;
import com.rafael.hexagonal.architecture.application.ports.out.FindAddressByZipCodeOutputPort;
import com.rafael.hexagonal.architecture.application.ports.out.InsertCustomerOutputPort;
import com.rafael.hexagonal.architecture.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort addressPort;
    private final InsertCustomerOutputPort insertPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;
    
    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort addressPort, InsertCustomerOutputPort insertPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.addressPort = addressPort;
        this.insertPort = insertPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        final Address address = addressPort.find(zipCode);

        customer.setAddress(address);

        insertPort.insert(customer);

        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
 
}
