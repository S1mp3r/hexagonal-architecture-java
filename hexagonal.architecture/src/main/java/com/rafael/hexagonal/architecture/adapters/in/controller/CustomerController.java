package com.rafael.hexagonal.architecture.adapters.in.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.hexagonal.architecture.adapters.in.controller.mapper.CustomerRequestMapper;
import com.rafael.hexagonal.architecture.adapters.in.controller.request.CustomerRequest;
import com.rafael.hexagonal.architecture.adapters.in.controller.response.CustomerResponse;
import com.rafael.hexagonal.architecture.application.ports.in.DeleteCustomerByIdInputPort;
import com.rafael.hexagonal.architecture.application.ports.in.FindCustomerByIdInputPort;
import com.rafael.hexagonal.architecture.application.ports.in.InsertCustomerInputPort;
import com.rafael.hexagonal.architecture.application.ports.in.UpdateCustomerByIdInputPort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@Tag(name = "CustomerController")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerByIdInputPort updateCustomerByIdInputPort;
    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
    private final CustomerRequestMapper customerRequestMapper;

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Endpoint for listing a customer by his Id",
     responses = @ApiResponse(
        content = @Content(mediaType = "application/json")
        )
    )
    public CustomerResponse findById(@PathVariable String id) {
        var customer = findCustomerByIdInputPort.findCustomer(id);
        return customerRequestMapper.toCustomerResponse(customer);
    }
    
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(description = "Endpoint for inserting a customer in the database")
    public void insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerRequestMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(description = "Endpoint for updating a customers zipCode by his Id and some of his information")
    public void putMethodName(@PathVariable String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerRequestMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerByIdInputPort.update(customer, customerRequest.getZipCode());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(description = "Endpoint for deleting a customer from the database")
    public void putMethodName(@PathVariable String id) {
        deleteCustomerByIdInputPort.delete(id);
    }

}
