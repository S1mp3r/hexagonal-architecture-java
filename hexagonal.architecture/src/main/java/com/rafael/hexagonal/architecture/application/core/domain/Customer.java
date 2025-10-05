package com.rafael.hexagonal.architecture.application.core.domain;

public class Customer {

    public Customer(){
        isValidCpf = false;
    }

    public Customer(String id, String name, Address address, String cpf, Boolean isValidCpf){
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
    }
    
    private String id;
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getaddress() {
        return address;
    }

    public String getCpf() {
        return cpf;
    }

    public Boolean getIsValidCpf() {
        return isValidCpf;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddres(Address address) {
        this.address = address;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIsValidCpf(Boolean isValidCpf) {
        this.isValidCpf = isValidCpf;
    }

}
