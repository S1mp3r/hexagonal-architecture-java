package com.rafael.hexagonal.architecture.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {
    
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Cpf is required")
    private String cpf;

    @NotBlank(message = "Cep is required")
    private String zipCode;

}
