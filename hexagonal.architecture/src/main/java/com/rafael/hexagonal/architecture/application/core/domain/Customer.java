package com.rafael.hexagonal.architecture.application.core.domain;

public class Customer {

    public Customer(){
        isValidCpf = false;
    }
    
    public Customer(String id, String name, Addres addres, String cpf, Boolean isValidCpf){
        this.id = id;
        this.name = name;
        this.addres = addres;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
    }
    
    private String id;
    private String name;
    private Addres addres;
    private String cpf;
    private Boolean isValidCpf;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Addres getAddres() {
        return addres;
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

    public void setAddres(Addres addres) {
        this.addres = addres;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIsValidCpf(Boolean isValidCpf) {
        this.isValidCpf = isValidCpf;
    }

}
