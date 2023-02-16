package com.mybank.banking.account.application.port.in;

import com.mybank.banking.account.domain.Customer;

import java.util.List;

public interface CustomerWebInputPort {

    public Customer save(Customer customer);

    public Customer update(Customer customer, Long id);

    public void deleteById(Long id);

    public Customer getById(Long id);

    public List<Customer> getAll();

}
