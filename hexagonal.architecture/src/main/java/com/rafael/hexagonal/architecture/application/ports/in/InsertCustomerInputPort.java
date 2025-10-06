package com.rafael.hexagonal.architecture.application.ports.in;

import com.rafael.hexagonal.architecture.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);

}