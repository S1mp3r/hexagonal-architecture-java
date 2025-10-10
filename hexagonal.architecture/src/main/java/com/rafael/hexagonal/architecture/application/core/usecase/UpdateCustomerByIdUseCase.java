package com.rafael.hexagonal.architecture.application.core.usecase;

import com.rafael.hexagonal.architecture.application.core.domain.Customer;
import com.rafael.hexagonal.architecture.application.ports.in.FindCustomerByIdInputPort;
import com.rafael.hexagonal.architecture.application.ports.in.UpdateCustomerByIdInputPort;
import com.rafael.hexagonal.architecture.application.ports.out.FindAddressByZipCodeOutputPort;
import com.rafael.hexagonal.architecture.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerByIdUseCase implements UpdateCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;
    private final FindAddressByZipCodeOutputPort addressPort;
    
    public UpdateCustomerByIdUseCase(
        FindCustomerByIdInputPort findCustomerByIdInputPort, 
        UpdateCustomerOutputPort updateCustomerOutputPort, 
        FindAddressByZipCodeOutputPort addressPort) 
        {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
        this.addressPort = addressPort;
    }


    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.findCustomer(customer.getId());
        var address = addressPort.find(zipCode);

        customer.setAddress(address);

        updateCustomerOutputPort.save(customer);
    }
    
}
