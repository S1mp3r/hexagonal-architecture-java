package com.rafael.hexagonal.architecture.adapters.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.rafael.hexagonal.architecture.application.ports.out.SendCpfForValidationOutputPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SendCpfForValidationAdapter implements SendCpfForValidationOutputPort {

    KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("cpf-validation-topic", cpf);
    }
    
}
