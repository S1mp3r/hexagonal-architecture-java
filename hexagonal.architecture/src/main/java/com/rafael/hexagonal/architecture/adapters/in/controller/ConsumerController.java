package com.rafael.hexagonal.architecture.adapters.in.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.hexagonal.architecture.adapters.in.controller.mapper.CustomerRequestMapper;
import com.rafael.hexagonal.architecture.adapters.in.controller.request.CustomerRequest;
import com.rafael.hexagonal.architecture.adapters.in.controller.response.CustomerResponse;
import com.rafael.hexagonal.architecture.application.ports.in.FindCustomerByIdInputPort;
import com.rafael.hexagonal.architecture.application.ports.in.InsertCustomerInputPort;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/costumers")
@RequiredArgsConstructor
public class ConsumerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final CustomerRequestMapper customerRequestMapper;

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CustomerResponse findById(@PathVariable("id") String id) {
        var customer = findCustomerByIdInputPort.findCustomer(id);
        return customerRequestMapper.toCustomerResponse(customer);
    }
    

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerRequestMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
    }
    

}
