package com.mybank.banking.account.adapter.out.persistence.adapter;

import com.mybank.banking.account.adapter.out.persistence.mapper.CustomerEntityMapper;
import com.mybank.banking.account.adapter.out.persistence.repository.CustomerRepository;
import com.mybank.banking.account.application.port.out.CustomerPersistenceOutputPort;
import com.mybank.banking.account.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class CustomerPersistenceAdapter implements CustomerPersistenceOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerMapper;

    @Override
    public Customer save(Customer customer) {
        return customerMapper.toDomain(customerRepository.save(customerMapper.toEntity(customer)));
    }

    @Override
    public Customer getById(Long id) {
        return customerMapper.toDomain(customerRepository.findById(id).orElseThrow());
    }

    @Override
    public List<Customer> getAll() {
        return customerMapper.mapToDomain(customerRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
