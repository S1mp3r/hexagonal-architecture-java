package com.rafael.hexagonal.architecture.config;

import com.rafael.hexagonal.architecture.adapters.out.FindAddressByZipCodeAdapter;
import com.rafael.hexagonal.architecture.adapters.out.InsertCustomerAdapter;
import com.rafael.hexagonal.architecture.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    InsertCustomerUseCase insertCustomerUseCase(
      FindAddressByZipCodeAdapter addressAdapter,
      InsertCustomerAdapter insertAdapter
    ) {
      return new InsertCustomerUseCase(addressAdapter, insertAdapter);
    }
}
