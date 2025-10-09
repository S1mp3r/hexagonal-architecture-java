package com.rafael.hexagonal.architecture.adapters.out;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.hexagonal.architecture.adapters.out.repository.CustomerRepository;
import com.rafael.hexagonal.architecture.application.ports.out.DeleteCustomerByIdOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {
    
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public void delete(String id) {
        customerRepository.deleteById(id);
    }

}
