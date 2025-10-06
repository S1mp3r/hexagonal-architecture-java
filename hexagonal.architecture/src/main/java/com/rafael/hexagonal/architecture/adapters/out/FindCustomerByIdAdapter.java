package com.rafael.hexagonal.architecture.adapters.out;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.rafael.hexagonal.architecture.adapters.out.repository.CustomerRepository;
import com.rafael.hexagonal.architecture.adapters.out.repository.mapper.CustomerMapper;
import com.rafael.hexagonal.architecture.application.core.domain.Customer;
import com.rafael.hexagonal.architecture.application.ports.out.FindCustomerByIdOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {
    
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Optional<Customer> findCustomer(String id) {
        var customer = customerRepository.findById(id);


        return customer.map(entity -> customerMapper.toCustomer(entity));
    }

}
