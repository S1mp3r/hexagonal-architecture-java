package com.rafael.hexagonal.architecture.adapters.in.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.rafael.hexagonal.architecture.adapters.in.consumer.message.CustomerMessage;
import com.rafael.hexagonal.architecture.application.ports.in.UpdateCustomerByIdInputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReceiveValidatedCpfConsumer {

    private final UpdateCustomerByIdInputPort updateCustomerByIdInputPort;
    private final CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "cpf-validation-topic", groupId = "rafael")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerByIdInputPort.update(customer, customerMessage.getZipCode());
    }
}