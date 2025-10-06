package com.rafael.hexagonal.architecture.application.ports.out;

import java.util.Optional;

import com.rafael.hexagonal.architecture.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {

    public Optional<Customer> findCustomer(String id);

}