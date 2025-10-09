package com.rafael.hexagonal.architecture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rafael.hexagonal.architecture.adapters.out.FindCustomerByIdAdapter;
import com.rafael.hexagonal.architecture.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class FindCustomerByIdConfig {
 
    
    @Bean
    FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }

}
