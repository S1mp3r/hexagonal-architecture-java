package com.rafael.hexagonal.architecture.adapters.out.client.response;

import lombok.Data;

@Data
public class AddressResponse {
    
    private String street;
    private String city;
    private String state;

}
