package com.br.rafael.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.br.rafael.model.CustomerMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CpfValidatorService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    
    @KafkaListener(topics = "cpf-validation-topic", groupId = "rafael")
    public void receive(String cpf) {
        var customer = new CustomerMessage();
        customer.setId("68e85bde38d2ea265f78458c");
        customer.setCpf(cpf);
        customer.setName("Rafael Teste Kafka, deu bom");
        customer.setZipCode("38400001");
        customer.setIsValidCpf(validateCpf(cpf));
        log.info("CPF - {}, it's a valid cpf? - {}!", customer.getCpf(), customer.getIsValidCpf());
        kafkaTemplate.send("cpf-validated-topic", customer);
    }

    private boolean validateCpf(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("[0-9]{11}")) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int soma = 0;
        int peso = 10;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }

        int digito1 = 11 - (soma % 11);
        if (digito1 == 10 || digito1 == 11) digito1 = 0;

        soma = 0;
        peso = 11;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }

        int digito2 = 11 - (soma % 11);
        if (digito2 == 10 || digito2 == 11) digito2 = 0;

        return digito1 == Character.getNumericValue(cpf.charAt(9)) && digito2 == Character.getNumericValue(cpf.charAt(10));
    }

}
