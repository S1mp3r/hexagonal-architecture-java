package com.rafael.hexagonal.architecture.adapters.out.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.hexagonal.architecture.adapters.out.client.response.AddressResponse;

@RestController
@FeignClient(name = "AddressClient", url = "${rafael.clients.address.url}")
public interface AddressClient {
    
    @GetMapping("/{zipCode}")
    public AddressResponse findAddressByZipCode(@PathVariable String zipCode);

}
