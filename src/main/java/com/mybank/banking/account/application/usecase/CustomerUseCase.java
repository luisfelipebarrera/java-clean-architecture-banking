package com.mybank.banking.account.application.usecase;

import com.mybank.banking.account.application.port.in.CustomerWebInputPort;
import com.mybank.banking.account.application.port.out.CustomerPersistenceOutputPort;
import com.mybank.banking.account.domain.Customer;
import com.mybank.banking.exceptions.CustomParameterConstraintException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class CustomerUseCase implements CustomerWebInputPort {

    private final CustomerPersistenceOutputPort customerPersistenceOutputPort;

    @Override
    public Customer save(Customer customer) {

        return customerPersistenceOutputPort.save(customer);
    }

    @Override
    public Customer update(Customer customer, Long id) {

        Customer existCustomer = customerPersistenceOutputPort.getById(id);
        if (!existCustomer.getId().equals(customer.getId())) {
            throw new CustomParameterConstraintException("Identifier not found in entity");
        }
        return customerPersistenceOutputPort.save(customer);
    }

    @Override
    public void deleteById(Long id) {

        Customer existCustomer = customerPersistenceOutputPort.getById(id);
        customerPersistenceOutputPort.deleteById(existCustomer.getId());
    }

    @Override
    public Customer getById(Long id) {

        return customerPersistenceOutputPort.getById(id);
    }

    @Override
    public List<Customer> getAll() {

        return customerPersistenceOutputPort.getAll();
    }
}
