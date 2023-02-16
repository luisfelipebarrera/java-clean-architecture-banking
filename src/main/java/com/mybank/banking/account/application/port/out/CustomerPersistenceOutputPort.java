package com.mybank.banking.account.application.port.out;

import com.mybank.banking.account.domain.Customer;

import java.util.List;

public interface CustomerPersistenceOutputPort {

    public Customer save(Customer customer);
    public Customer getById(Long id);
    public List<Customer> getAll();
    public void deleteById(Long id);

}
