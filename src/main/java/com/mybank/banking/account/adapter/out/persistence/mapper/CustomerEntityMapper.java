package com.mybank.banking.account.adapter.out.persistence.mapper;

import com.mybank.banking.account.adapter.out.persistence.entity.CustomerEntity;
import com.mybank.banking.account.domain.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    Customer toDomain(CustomerEntity customerEntity);
    List<Customer> mapToDomain(List<CustomerEntity> employees);
    CustomerEntity toEntity(Customer user);

}
