package com.rafael.hexagonal.architecture.adapters.out;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.hexagonal.architecture.adapters.out.repository.CustomerRepository;
import com.rafael.hexagonal.architecture.adapters.out.repository.mapper.CustomerMapper;
import com.rafael.hexagonal.architecture.application.core.domain.Customer;
import com.rafael.hexagonal.architecture.application.ports.out.InsertCustomerOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {
 
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    @Transactional
    public Customer insert(Customer customer) {
        var customerEntity = customerMapper.toCustomerEntity(customer);
        customerEntity = customerRepository.save(customerEntity);
        return customerMapper.toCustomer(customerEntity);
    }

}
