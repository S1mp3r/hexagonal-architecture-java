package com.rafael.hexagonal.architecture.application.core.usecase;

import com.rafael.hexagonal.architecture.application.core.domain.Customer;
import com.rafael.hexagonal.architecture.application.ports.in.FindCustomerByIdInputPort;
import com.rafael.hexagonal.architecture.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {
 
    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;
    
    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer findCustomer(String id) {
        return findCustomerByIdOutputPort.findCustomer(id).orElseThrow(() -> new RuntimeException("Customer not found!"));
    };
    
}
