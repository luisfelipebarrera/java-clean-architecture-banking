package com.mybank.banking.account.adapter.in.web.mapper;

import com.mybank.banking.account.domain.Customer;
import com.mybank.banking.account.adapter.in.web.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "gender.genderDescription", target = "genderDescription")
    CustomerDto toDto (Customer customer);
    Customer toDomain(CustomerDto customerDto);

}
