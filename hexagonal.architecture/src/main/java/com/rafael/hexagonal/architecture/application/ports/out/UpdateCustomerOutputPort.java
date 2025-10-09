package com.rafael.hexagonal.architecture.application.ports.out;

import com.rafael.hexagonal.architecture.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void save(Customer customer);

}