package com.rafael.hexagonal.architecture.application.ports.in;

import com.rafael.hexagonal.architecture.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer findCustomer(String id);
    
}