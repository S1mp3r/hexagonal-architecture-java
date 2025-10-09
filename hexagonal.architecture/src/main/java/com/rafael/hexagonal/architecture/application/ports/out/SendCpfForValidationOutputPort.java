package com.rafael.hexagonal.architecture.application.ports.out;

public interface SendCpfForValidationOutputPort {
 
    void send(String cpf);
    
}
