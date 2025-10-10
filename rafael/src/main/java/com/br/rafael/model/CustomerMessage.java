package com.br.rafael.model;

import lombok.Data;

@Data
public class CustomerMessage {

    private String id;
    private String name;
    private String zipCode;
    private String cpf;
    private Boolean isValidCpf;

}
