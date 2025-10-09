package com.rafael.hexagonal.architecture.adapters.out;

import org.springframework.stereotype.Component;

import com.rafael.hexagonal.architecture.adapters.out.repository.CustomerRepository;
import com.rafael.hexagonal.architecture.adapters.out.repository.mapper.CustomerMapper;
import com.rafael.hexagonal.architecture.application.core.domain.Customer;
import com.rafael.hexagonal.architecture.application.ports.out.UpdateCustomerOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public void save(Customer customer) {
        var customerEntity = customerMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
 
}
