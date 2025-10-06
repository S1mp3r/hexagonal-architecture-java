package com.rafael.hexagonal.architecture.adapters.in.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.hexagonal.architecture.adapters.in.controller.mapper.CustomerRequestMapper;
import com.rafael.hexagonal.architecture.adapters.in.controller.request.CustomerRequest;
import com.rafael.hexagonal.architecture.application.ports.in.InsertCustomerInputPort;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/costumers")
@RequiredArgsConstructor
public class ConsumerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final CustomerRequestMapper customerRequestMapper;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void postMethodName(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerRequestMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
    }
    

}
