package com.mybank.banking;

import com.mybank.banking.account.application.port.in.CustomerWebInputPort;
import com.mybank.banking.account.application.port.out.CustomerPersistenceOutputPort;
import com.mybank.banking.account.application.usecase.CustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankingApplicationConfig {

    /*
    @Bean
    public CustomerUseCase customerUseCase(CustomerPersistenceOutputPort customerPersistenceOutputPort) {
        return new CustomerUseCase(customerPersistenceOutputPort);
    }
     */

}
