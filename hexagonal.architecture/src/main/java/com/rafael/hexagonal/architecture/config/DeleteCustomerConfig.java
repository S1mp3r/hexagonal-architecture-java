package com.rafael.hexagonal.architecture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rafael.hexagonal.architecture.adapters.out.DeleteCustomerByIdAdapter;
import com.rafael.hexagonal.architecture.application.core.usecase.DeleteCustomerUseCase;
import com.rafael.hexagonal.architecture.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    DeleteCustomerUseCase deleteCustomerUseCase(
        FindCustomerByIdUseCase findCustomerByIdUseCase, 
        DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
        ) {
        return new DeleteCustomerUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }

}
