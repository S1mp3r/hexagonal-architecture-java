package com.rafael.hexagonal.architecture.application.ports.in;

import com.rafael.hexagonal.architecture.application.core.domain.Customer;

public interface UpdateCustomerByIdInputPort {
    
    void update(Customer customer, String zipCode);

}
