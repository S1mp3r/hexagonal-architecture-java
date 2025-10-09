package com.rafael.hexagonal.architecture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rafael.hexagonal.architecture.adapters.out.FindAddressByZipCodeAdapter;
import com.rafael.hexagonal.architecture.adapters.out.UpdateCustomerAdapter;
import com.rafael.hexagonal.architecture.application.core.usecase.FindCustomerByIdUseCase;
import com.rafael.hexagonal.architecture.application.core.usecase.UpdateCustomerByIdUseCase;

@Configuration
public class UpdateCustomerByIdConfig  {

    @Bean
    UpdateCustomerByIdUseCase updateCustomerByIdUseCase(
        FindCustomerByIdUseCase findCustomerByIdUseCase, 
        UpdateCustomerAdapter updateCustomerAdapter, 
        FindAddressByZipCodeAdapter addressByZipCodeAdapter
        ) {
        return new UpdateCustomerByIdUseCase(findCustomerByIdUseCase, updateCustomerAdapter, addressByZipCodeAdapter);
    }
    
}
